package org.xukmin.magicbrush;

import java.awt.Color;
import java.lang.reflect.Field;

public class ColorParser {
  public static Color parse(String s, Color default_color) {
    Color color;
    try {
      Field field = Color.class.getField(s);
      color = (Color) field.get(null);
    } catch (IllegalAccessException | IllegalArgumentException
        | NoSuchFieldException | SecurityException e) {
      color = default_color;
    }
    return color;
  }
}
