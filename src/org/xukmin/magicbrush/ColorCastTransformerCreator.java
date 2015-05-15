package org.xukmin.magicbrush;

import java.util.Map;

public class ColorCastTransformerCreator implements ImageTransformerCreator {
  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new ColorCastTransformer(params);
  }
}
