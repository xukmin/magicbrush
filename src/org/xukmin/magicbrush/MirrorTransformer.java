package org.xukmin.magicbrush;

import java.awt.image.BufferedImage;
import java.util.Map;

public class MirrorTransformer implements ImageTransformer {
  public MirrorTransformer() {
  }

  public MirrorTransformer(Map<String, String> params) {
  }

  @Override
  public BufferedImage transform(BufferedImage source) {
    BufferedImage target = new BufferedImage(
        source.getWidth(), source.getHeight(), source.getType());
    
    int w = source.getWidth();
    int h = source.getHeight();
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        target.setRGB(x, y, source.getRGB(w - 1 - x, y));
      }
    }
    
    return target; 
  }
}
