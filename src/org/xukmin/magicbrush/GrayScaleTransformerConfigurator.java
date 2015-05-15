package org.xukmin.magicbrush;

@SuppressWarnings("serial")
public class GrayScaleTransformerConfigurator extends
    ImageTransformerConfigurator<GrayScaleTransformer> {
  public GrayScaleTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new GrayScaleTransformer());
  }
}