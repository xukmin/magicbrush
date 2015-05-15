package org.xukmin.magicbrush;

import java.awt.Color;
import java.awt.image.BufferedImage;

public abstract class ColorTransformer implements ImageTransformer {
  @Override
  public final BufferedImage transform(BufferedImage source) {
    BufferedImage target =
        new BufferedImage(source.getWidth(), source.getHeight(), source.getType());

    for (int y = 0; y < source.getHeight(); y++) {
      for (int x = 0; x < source.getWidth(); x++) {
        target.setRGB(x, y, transformColor(new Color(source.getRGB(x, y))).getRGB());
      }
    }
    
    return target;
  }
 
  abstract protected Color transformColor(Color c);
}
