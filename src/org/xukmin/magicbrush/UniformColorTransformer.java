package org.xukmin.magicbrush;

import java.awt.Color;

public abstract class UniformColorTransformer extends ColorTransformer {
  @Override
  protected Color transformColor(Color c) {
    return new Color(transformColorComponent(c.getRed()),
                     transformColorComponent(c.getGreen()),
                     transformColorComponent(c.getBlue()));
  }
  
  abstract protected int transformColorComponent(int c);
}
