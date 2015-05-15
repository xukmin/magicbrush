// MagicBrush
// Author: Min Xu <xukmin@gmail.com>

package org.xukmin.magicbrush;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is the Command Line Interface of MagicBrush.
 */
public class MagicBrushCli {
  public static void showUsage() {
    System.out.println("Usage:");
    System.out.println("<command>\n" +
                       "  [--input=<input-file>]\n" +
                       "  [--output=<output-file>]\n" +
                       "  [--<param>=<value> ...]");
  }
  @SuppressWarnings("serial")
  public static final Map<String, ImageTransformerCreator> commands =
      new TreeMap<String, ImageTransformerCreator>() {
        {
          put("Blur", new BlurTransformerCreator());
          put("ColoredDots", new ColoredDotsTransformerCreator());
          put("ColorCast", new ColorCastTransformerCreator());
          put("ColorEnhance", new ColorEnhanceTransformerCreator());
          put("ColorInvert", new ColorInvertTransformerCreator());
          put("GrayScale", new GrayScaleTransformerCreator());
          put("Mirror", new MirrorTransformerCreator());
          put("Recolor", new RecolorTransformerCreator());
          put("UpsideDown", new UpsideDownTransformerCreator());
          put("Wobble", new WobbleTransformerCreator());
        }
      };

  public static void main(String[] args) {
    if (args.length == 0) {
      showUsage();
      return;
    }
    String command = args[0];
    Map<String, String> params = new TreeMap<String, String>();
    for (int i = 1; i < args.length; i++) {
      if (args[i].startsWith("--")) {
        String[] kv = args[i].substring(2).split("=");
        if (kv.length != 2) {
          System.err.println("Invalid Argument: " + args[i]);
          showUsage();
          return;
        }
        params.put(kv[0], kv[1]);
      }
    }
    String input = null;
    if (params.containsKey("input")) {
      input = params.get("input");
      params.remove("input");
    }
    String output = null;
    if (params.containsKey("output")) {
      output = params.get("output");
      params.remove("output");
    }
    if (!commands.containsKey(command)) {
      System.err.println("Unknown command: " + command);
      showUsage();
      return;
    }

    BufferedImage input_image = null;
    try {
      input_image = ImageIO.read(new File(input));
    } catch (IOException e) {
      System.err.println("Failed to read image from " + input);
      System.exit(1);
    }

    ImageTransformer transformer = commands.get(command).create(params);
    BufferedImage output_image = transformer.transform(input_image);

    try {
      ImageIO.write(output_image, "jpg", new File(output));
    } catch (IOException e) {
      System.err.println("Failed to write image to " + output);
      System.exit(1);
    }
  }
}
