package org.xukmin.magicbrush;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.util.Map;

public class ColorEnhanceTransformer extends UniformColorTransformer {
  public ColorEnhanceTransformer(int lowerThreshold, int upperThreshold,
      float lowerMultiplier, float upperMultiplier) {
    this.lowerThreshold = lowerThreshold;
    this.upperThreshold = upperThreshold;
    this.lowerMultiplier = lowerMultiplier;
    this.upperMultiplier = upperMultiplier;
  }

  public ColorEnhanceTransformer() {
    this(DEFAULT_LOWER_THRESHOLD, DEFAULT_UPPER_THRESHOLD,
        DEFAULT_LOWER_MULTIPLIER, DEFAULT_UPPER_MULTIPLIER);
  }

  public ColorEnhanceTransformer(Map<String, String> params) {
    this();
    if (params.containsKey("lowerThreshold")) {
      lowerThreshold = Integer.parseInt(params.get("lowerThreshold"));
    }
    if (params.containsKey("upperThreshold")) {
      upperThreshold = Integer.parseInt(params.get("upperThreshold"));
    }
    if (params.containsKey("lowerMultiplier")) {
      lowerMultiplier = Float.parseFloat(params.get("lowerMultiplier"));
    }
    if (params.containsKey("upperMultiplier")) {
      upperMultiplier = Float.parseFloat(params.get("upperMultiplier"));
    }    
  }

  public void setLowerThreshold(int lowerThreshold) {
    this.lowerThreshold = lowerThreshold;
  }
  
  public int getLowerThreshold() {
    return lowerThreshold;
  }
 
  public void setUpperThreshold(int upperThreshold) {
    this.upperThreshold = upperThreshold;
  }
  
  public int getUpperThreshold() {
    return upperThreshold;
  }
 
  public void setLowerMultiplier(float lowerMultiplier) {
    this.lowerMultiplier = lowerMultiplier;
  }
  
  public float getLowerMultiplier() {
    return lowerMultiplier;
  }
 
  public void setUpperMultiplier(float upperMultiplier) {
    this.upperMultiplier = upperMultiplier;
  }
  
  public float getUpperMultiplier() {
    return upperMultiplier;
  }
  
  @Override 
  protected int transformColorComponent(int c) {
    if (c < lowerThreshold) {
      c = Math.min((int) (c * lowerMultiplier), 255);
    } else if (c > upperThreshold) {
      c = Math.min((int) (c * upperMultiplier), 255);
    }
    return c;
  }
  
  private int lowerThreshold;
  private int upperThreshold;
  private float lowerMultiplier;
  private float upperMultiplier;

  public static final int DEFAULT_LOWER_THRESHOLD = 55;
  public static final int DEFAULT_UPPER_THRESHOLD = 200;
  public static final float DEFAULT_LOWER_MULTIPLIER = 0.95f;
  public static final float DEFAULT_UPPER_MULTIPLIER = 1.05f;
}
