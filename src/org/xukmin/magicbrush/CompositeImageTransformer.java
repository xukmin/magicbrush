package org.xukmin.magicbrush;

import java.awt.image.BufferedImage;

public abstract class CompositeImageTransformer implements ImageTransformer {
  public CompositeImageTransformer(ImageTransformer firstTransformer,
      ImageTransformer secondTransformer) {
    this.firstTransformer = firstTransformer;
    this.secondTransformer = secondTransformer;
  }

  @Override
  public BufferedImage transform(BufferedImage source) {
    return secondTransformer.transform(firstTransformer.transform(source));
  }
  
  protected ImageTransformer firstTransformer;
  protected ImageTransformer secondTransformer;
}
