package org.xukmin.magicbrush;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class BlurTransformerConfigurator extends
    ImageTransformerConfigurator<BlurTransformer> {
  public BlurTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new BlurTransformer());
    
    SpinnerModel radiusModel =
        new SpinnerNumberModel(BlurTransformer.DEFAULT_RADIUS, 2, 50, 1);
    final JSpinner radiusSpinner = new JSpinner(radiusModel);
    radiusSpinner.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        transformer.setRadius(((Integer) radiusSpinner.getValue()).intValue());
        updateImage();
      }
    });
    add(new JLabel("Dot height:"));
    add(radiusSpinner);

  }
}
