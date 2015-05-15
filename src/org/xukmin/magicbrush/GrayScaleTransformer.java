package org.xukmin.magicbrush;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Map;

public class GrayScaleTransformer extends ColorTransformer {
  public GrayScaleTransformer() {
  }
  
  public GrayScaleTransformer(Map<String, String> params) {
  }
 
  @Override
  protected Color transformColor(Color c) {
    int gray = (int) (0.21 * c.getRed() + 0.72 * c.getGreen() + 0.07 * c.getBlue());
    return new Color(gray, gray, gray);
  }
}