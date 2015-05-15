package org.xukmin.magicbrush;

@SuppressWarnings("serial")
public class ColorInvertTransformerConfigurator extends ImageTransformerConfigurator<ColorInvertTransformer> {
  public ColorInvertTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new ColorInvertTransformer());
  }
}
