package org.xukmin.magicbrush;

import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ColorEnhanceTransformerConfigurator extends
    ImageTransformerConfigurator<ColorEnhanceTransformer> {
  public ColorEnhanceTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new ColorEnhanceTransformer());

    {
      SpinnerModel model =
          new SpinnerNumberModel(ColorEnhanceTransformer.DEFAULT_LOWER_THRESHOLD, 0, 255, 1);
      final JSpinner spinner = new JSpinner(model);
      
      spinner.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          transformer.setLowerThreshold(((Integer) spinner.getValue()).intValue());
        }
      });
      
      add(new JLabel("Lower Threshold:"));
      add(spinner);
    }
   
    {
      SpinnerModel model =
          new SpinnerNumberModel(ColorEnhanceTransformer.DEFAULT_UPPER_THRESHOLD, 0, 255, 1);
      final JSpinner spinner = new JSpinner(model);
      
      spinner.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          transformer.setLowerThreshold(((Integer) spinner.getValue()).intValue());
        }
      });

      add(new JLabel("Upper Threshold:"));
      add(spinner);
    }
    
    {
      
      SpinnerModel model =
          new SpinnerNumberModel(ColorEnhanceTransformer.DEFAULT_LOWER_MULTIPLIER, 0.1, 10, 0.1);
      final JSpinner spinner = new JSpinner(model);
      JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinner.getEditor();
      DecimalFormat format = editor.getFormat();
      editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
      Dimension d = spinner.getPreferredSize();
      d.width = 85;
      spinner.setPreferredSize(d);
      format.setMinimumFractionDigits(1);

      spinner.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          transformer.setLowerMultiplier(((Double) spinner.getValue()).floatValue());
          updateImage();
        }
      });

      add(new JLabel("Lower Multiplier:"));
      add(spinner);
    }
    
    {
      SpinnerModel model =
          new SpinnerNumberModel(ColorEnhanceTransformer.DEFAULT_UPPER_MULTIPLIER, 0.1, 10, 0.1);
      final JSpinner spinner = new JSpinner(model);
      JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinner.getEditor();
      DecimalFormat format = editor.getFormat();
      editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
      Dimension d = spinner.getPreferredSize();
      d.width = 85;
      spinner.setPreferredSize(d);
      format.setMinimumFractionDigits(1);

      spinner.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          transformer.setUpperMultiplier(((Double) spinner.getValue()).floatValue());
          updateImage();
        }
      });

      add(new JLabel("Upper Multiplier:"));
      add(spinner);
    }
  }
}
