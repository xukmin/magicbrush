package org.xukmin.magicbrush;

import java.awt.Color;
import java.util.Map;

public class RecolorTransformer extends CompositeImageTransformer implements ImageTransformer {
  public RecolorTransformer(Color targetColor) {
    super(new GrayScaleTransformer(), new ColorCastTransformer(targetColor));
    grayScaleTransformer = (GrayScaleTransformer) firstTransformer;
    colorCastTransformer = (ColorCastTransformer) secondTransformer;
  }
  
  public RecolorTransformer() {
    this(DEFAULT_TARGET_COLOR);
  }
  
  public RecolorTransformer(Map<String, String> params) {
    super(new GrayScaleTransformer(params), new ColorCastTransformer(params));
    colorCastTransformer = (ColorCastTransformer) secondTransformer;
  }
  
  public void setTargetColor(Color targetColor) {
    colorCastTransformer.setTargetColor(targetColor);
  }
  
  public Color getTargetColor() {
    return colorCastTransformer.getTargetColor();
  }

  @SuppressWarnings("unused")
  private GrayScaleTransformer grayScaleTransformer;
  
  private ColorCastTransformer colorCastTransformer;
  
  public static final Color DEFAULT_TARGET_COLOR = ColorCastTransformer.DEFAULT_TARGET_COLOR;
}
