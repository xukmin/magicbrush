package org.xukmin.magicbrush;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImageTransformerConfigurator<T extends ImageTransformer> extends JPanel {
  public ImageTransformerConfigurator(MagicBrushPanel panel, T transformer) {
    this.panel = panel;
    this.transformer = transformer;
    panel.pushOldImage();
    panel.history.add(panel.getOldImage());
    updateImage();
  }
  
  protected void updateImage() {
    panel.setNewImage(transformer.transform(panel.getOldImage()));
  }
  
  private MagicBrushPanel panel;
  protected T transformer;
}
