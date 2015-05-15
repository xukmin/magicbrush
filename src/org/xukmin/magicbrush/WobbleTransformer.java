package org.xukmin.magicbrush;

import java.awt.image.BufferedImage;
import java.util.Map;

public class WobbleTransformer implements ImageTransformer {
  public WobbleTransformer(int cycle, int amplitude) {
    this.cycle = cycle;
    this.amplitude = amplitude;
  }

  public WobbleTransformer() {
    this(DEFAULT_CYCLE, DEFAULT_AMPLITUDE);
  }
  
  public WobbleTransformer(Map<String, String> params) {
    this();
    if (params.containsKey("cycle")) {
      cycle = Integer.parseInt(params.get("cycle"));
    }
    if (params.containsKey("amplitude")) {
      amplitude = Integer.parseInt(params.get("amplitude"));
    }
  }

  @Override
  public BufferedImage transform(BufferedImage source) {
    BufferedImage target = new BufferedImage(
        source.getWidth() + 2 * amplitude, source.getHeight(), source.getType());
    
    int w = source.getWidth();
    int h = source.getHeight();
    for (int y = 0; y < h; y++) {
      int shift = (int) (Math.sin(y * Math.PI / cycle) * amplitude);
      for (int x = 0; x < w; x++) {
        target.setRGB(x + shift + amplitude, y, source.getRGB(x, y));
      }
    }
    
    return target; 
  } 
  
  void setCycle(int cycle) {
    this.cycle = cycle;
  }
  
  int getCycle() {
    return cycle;
  }
  
  void setAmplitude(int amplitude) {
    this.amplitude = amplitude;
  }
  
  int getAmplitude() {
    return amplitude;
  }

  private int cycle;
  private int amplitude;
  
  public static final int DEFAULT_CYCLE = 50;
  public static final int DEFAULT_AMPLITUDE = 10;
}
