package org.xukmin.magicbrush;

import java.util.Map;

public class WobbleTransformerCreator implements ImageTransformerCreator {
  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new WobbleTransformer(params);
  }
}
