package org.xukmin.magicbrush;

import java.util.Map;

public class UpsideDownTransformerCreator implements ImageTransformerCreator {

  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new UpsideDownTransformer(params);
  }

}
