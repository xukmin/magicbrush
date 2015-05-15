package org.xukmin.magicbrush;

@SuppressWarnings("serial")
public class UpsideDownTransformerConfigurator extends
    ImageTransformerConfigurator<UpsideDownTransformer> {
  public UpsideDownTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new UpsideDownTransformer());
  }
}
