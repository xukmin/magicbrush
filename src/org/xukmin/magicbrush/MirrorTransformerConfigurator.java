package org.xukmin.magicbrush;

@SuppressWarnings("serial")
public class MirrorTransformerConfigurator extends ImageTransformerConfigurator<MirrorTransformer> {
  public MirrorTransformerConfigurator(MagicBrushPanel panel) {
    super(panel, new MirrorTransformer());
  }
}
