package org.xukmin.magicbrush;

import java.util.Map;

public class BlurTransformerCreator implements ImageTransformerCreator {
  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new BlurTransformer(params);
  }
}
