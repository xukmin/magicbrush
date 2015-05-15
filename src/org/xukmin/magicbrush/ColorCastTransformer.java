package org.xukmin.magicbrush;

import java.awt.Color;
import java.util.Map;

public class ColorCastTransformer extends ColorTransformer {
  public ColorCastTransformer(Color targetColor) {
    this.targetColor = targetColor;
  }
  
  public ColorCastTransformer() {
    this(DEFAULT_TARGET_COLOR);
  }
  
  public ColorCastTransformer(Map<String, String> params) {
    this();
    if (params.containsKey("targetColor")) {
      targetColor = ColorParser.parse(params.get("targetColor"), DEFAULT_TARGET_COLOR);
    }
  }
  
  public void setTargetColor(Color targetColor) {
    this.targetColor = targetColor;
  }
  
  public Color getTargetColor() {
    return targetColor;
  }
  
  @Override
  protected Color transformColor(Color c) {
    int red = (int) (c.getRed() + (1 - c.getRed() / 255.0) * targetColor.getRed());
    int green = (int) (c.getGreen() + (1 - c.getGreen() / 255.0) * targetColor.getGreen());
    int blue = (int) (c.getBlue() + (1 - c.getBlue() / 255.0) * targetColor.getBlue());
    
    return new Color(red, green, blue);
  }
  
  private Color targetColor;
  
  public static final Color DEFAULT_TARGET_COLOR = Color.RED;
}
