package org.xukmin.magicbrush;

import java.awt.image.BufferedImage;
import java.util.Map;

public class UpsideDownTransformer implements ImageTransformer {
  public UpsideDownTransformer() {
  }
  
  public UpsideDownTransformer(Map<String, String> params) {
  }

  @Override
  public BufferedImage transform(BufferedImage source) {
    BufferedImage target = new BufferedImage(
        source.getWidth(), source.getHeight(), source.getType());
    
    int width = source.getWidth();
    int height = source.getHeight();
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        target.setRGB(x, y, source.getRGB(x, height - 1 - y));
      }
    }
    
    return target; 
  }
}
