package org.xukmin.magicbrush;

import java.util.Map;

public class ColoredDotsTransformerCreator implements ImageTransformerCreator {
  @Override
  public ColoredDotsTransformer create(Map<String, String> params) {
    return new ColoredDotsTransformer(params);
  }
}
