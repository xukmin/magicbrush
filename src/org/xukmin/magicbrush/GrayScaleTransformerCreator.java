package org.xukmin.magicbrush;

import java.util.Map;

public class GrayScaleTransformerCreator implements ImageTransformerCreator {
  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new GrayScaleTransformer(params);
  }
}
