package org.xukmin.magicbrush;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class RecolorTransformerConfigurator extends
    ImageTransformerConfigurator<RecolorTransformer> {
  public RecolorTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new RecolorTransformer());
    
    final JColorChooser targetColorChooser = new JColorChooser(RecolorTransformer.DEFAULT_TARGET_COLOR);
    targetColorChooser.setPreviewPanel(new JPanel());
    targetColorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent changeEvent) {
        transformer.setTargetColor(targetColorChooser.getColor());
        updateImage();
      }
    });
    add(new JLabel("Target Color:"));
    add(targetColorChooser);
  }
}
