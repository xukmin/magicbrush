package org.xukmin.magicbrush;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.util.Map;

public class ColoredDotsTransformer implements ImageTransformer {
  public ColoredDotsTransformer(int dotWidth, int dotHeight, Color background) {
    this.dotWidth = dotWidth;
    this.dotHeight = dotHeight;
    this.background = background;
  }

  public ColoredDotsTransformer() {
    this(DEFAULT_DOT_WIDTH, DEFAULT_DOT_HEIGHT, DEFAULT_BACKGROUND);
  }

  public ColoredDotsTransformer(Map<String, String> params) {
    this();
    if (params.containsKey("dotWidth")) {
      dotWidth = Integer.parseInt(params.get("dotWidth"));
    }
    if (params.containsKey("dotHeight")) {
      dotHeight = Integer.parseInt(params.get("dotHeight"));
    }
    if (params.containsKey("background")) {
      background = ColorParser.parse(params.get("background"), DEFAULT_BACKGROUND);
    }
  }

  public void setDotWidth(int dot_width) {
    this.dotWidth = dot_width;
  }
  
  public int getDotWidth() {
    return dotWidth;
  }
  
  public void setDotHeight(int dot_height) {
    this.dotHeight = dot_height;
  }
  
  public int getDotHeight() {
    return dotHeight;
  }
  
  public void setBackground(Color background) {
    this.background = background;
  }
  
  public Color getBackground() {
    return background;
  }
    
  @Override
  public BufferedImage transform(BufferedImage source) {
    BufferedImage target =
        new BufferedImage(source.getWidth(), source.getHeight(), source.getType());

    Graphics2D g = target.createGraphics();
    g.setColor(background);
    g.fillRect(0, 0, target.getWidth(), target.getHeight());

    int blockArea = dotWidth * dotHeight;
    for (int x = 0; x < source.getWidth() - dotWidth; x += dotWidth) {
      for (int y = 0; y < source.getHeight() - dotHeight; y += dotHeight) {
        float[] components = new float[3];
        float[] c = new float[3];
        for (int i = 0; i < dotWidth; i++) {
          for (int j = 0; j < dotHeight; j++) {
            Color color = new Color(source.getRGB(x + i, y + j));
            color.getRGBColorComponents(c);
            components[0] += c[0];
            components[1] += c[1];
            components[2] += c[2];
          }
        }
        components[0] /= blockArea;
        components[1] /= blockArea;
        components[2] /= blockArea;
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        g.setColor(new Color(cs, components, 1.0f));
        g.fillOval(x, y, dotWidth, dotHeight);
      }
    }
    return target;
  }
  
  private int dotWidth;
  private int dotHeight;
  private Color background;

  public static final int DEFAULT_DOT_WIDTH = 10;
  public static final int DEFAULT_DOT_HEIGHT = 10;
  public static final Color DEFAULT_BACKGROUND = new Color(0, true);
}
