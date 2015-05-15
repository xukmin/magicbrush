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
public class WobbleTransformerConfigurator extends
    ImageTransformerConfigurator<WobbleTransformer> {
  public WobbleTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new WobbleTransformer());

    {
      SpinnerModel model =
          new SpinnerNumberModel(WobbleTransformer.DEFAULT_CYCLE, 0, 100, 1);
      final JSpinner spinner = new JSpinner(model);
      
      spinner.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          transformer.setCycle(((Integer) spinner.getValue()).intValue());
          updateImage();
        }
      });
      
      add(new JLabel("Cycle:"));
      add(spinner);
    }
   
    {
      SpinnerModel model =
          new SpinnerNumberModel(WobbleTransformer.DEFAULT_AMPLITUDE, 0, 100, 1);
      final JSpinner spinner = new JSpinner(model);
      
      spinner.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          transformer.setAmplitude(((Integer) spinner.getValue()).intValue());
          updateImage();
        }
      });

      add(new JLabel("Amplitude:"));
      add(spinner);
    }
  }
}
