package org.xukmin.magicbrush;

import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ColoredDotsTransformerConfigurator extends
    ImageTransformerConfigurator<ColoredDotsTransformer> {
  public ColoredDotsTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new ColoredDotsTransformer());
    
    final JCheckBox roundDots = new JCheckBox("Round Dots");
    roundDots.setSelected(true);
    add(roundDots);
    
    SpinnerModel dotHeightModel =
        new SpinnerNumberModel(ColoredDotsTransformer.DEFAULT_DOT_HEIGHT, 2, 50, 1);
    SpinnerModel dotWidthModel =
        new SpinnerNumberModel(ColoredDotsTransformer.DEFAULT_DOT_WIDTH, 2, 50, 1);

    final JSpinner dotHeightSpinner = new JSpinner(dotHeightModel);
    final JSpinner dotWidthSpinner = new JSpinner(dotWidthModel);
    
    dotHeightSpinner.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        transformer.setDotHeight(((Integer) dotHeightSpinner.getValue()).intValue());
        if (roundDots.isSelected()) {
          dotWidthSpinner.setValue(dotHeightSpinner.getValue());
        }
        updateImage();
      }
    });
    add(new JLabel("Dot height:"));
    add(dotHeightSpinner);

    dotWidthSpinner.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        transformer.setDotWidth(((Integer) dotWidthSpinner.getValue()).intValue());
        if (roundDots.isSelected()) {
          dotHeightSpinner.setValue(dotWidthSpinner.getValue());
        }
        updateImage();
      }
    });
    add(new JLabel("Dot width:"));
    add(dotWidthSpinner);
    
    final JColorChooser backgroundChooser = new JColorChooser(ColoredDotsTransformer.DEFAULT_BACKGROUND);
    backgroundChooser.setPreviewPanel(new JPanel());
    backgroundChooser.getSelectionModel().addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent changeEvent) {
        transformer.setBackground(backgroundChooser.getColor());
        updateImage();
      }
    });
    add(new JLabel("Background:"));
    add(backgroundChooser);
  }
}
