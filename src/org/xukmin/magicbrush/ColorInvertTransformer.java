package org.xukmin.magicbrush;

import java.util.Map;

public class ColorInvertTransformer extends UniformColorTransformer {
  ColorInvertTransformer() {
  }
  
  ColorInvertTransformer(Map<String, String> params) {
  }
  
  @Override
  protected int transformColorComponent(int c) {
    return 255 - c;
  }
}
