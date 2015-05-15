package org.xukmin.magicbrush;

import java.util.Map;

public class ColorInvertTransformerCreator implements ImageTransformerCreator {
  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new ColorInvertTransformer(params);
  }
}
