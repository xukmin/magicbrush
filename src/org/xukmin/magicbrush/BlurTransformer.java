package org.xukmin.magicbrush;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Map;

public class BlurTransformer implements ImageTransformer {
  public BlurTransformer(int radius) {
    this.radius = radius;
  }
  
  public BlurTransformer() {
    this(DEFAULT_RADIUS);
  }
  
  public BlurTransformer(Map<String, String> params) {
    this();
    if (params.containsKey("radius")) {
      radius = Integer.parseInt(params.get("radius"));
    }
  }
  
  public void setRadius(int radius) {
    this.radius = radius;
  }
  
  public int getRadius() {
    return radius;
  }
  
  @Override
  public BufferedImage transform(BufferedImage source) {
    int square = radius * radius;
    float[] matrix = new float[square];
    for (int i = 0; i < square; i++) {
      matrix[i] = 1.0f / square;
    }

    BufferedImageOp op =
        new ConvolveOp(new Kernel(radius, radius, matrix), ConvolveOp.EDGE_ZERO_FILL, null);
    ColorModel cm = source.getColorModel();
    BufferedImage target =
        new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
    
    return op.filter(source, target);
  }

  private int radius;
  
  public static final int DEFAULT_RADIUS = 10;
}
