package org.xukmin.magicbrush;

import java.util.Map;

public interface ImageTransformerCreator {
  ImageTransformer create(Map<String, String> params);
}
