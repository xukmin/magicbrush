package org.xukmin.magicbrush;

import java.util.Map;

public class MirrorTransformerCreator implements ImageTransformerCreator {
  @Override
  public ImageTransformer create(Map<String, String> params) {
    return new MirrorTransformer(params);
  }
}
