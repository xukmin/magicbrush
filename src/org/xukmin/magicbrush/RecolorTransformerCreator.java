package org.xukmin.magicbrush;

import java.util.Map;

public class RecolorTransformerCreator implements ImageTransformerCreator {
  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new RecolorTransformer(params);
  }
}
