package org.xukmin.magicbrush;

import java.util.Map;

public class ColorEnhanceTransformerCreator implements ImageTransformerCreator {

  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new ColorEnhanceTransformer(params);
  }

}
