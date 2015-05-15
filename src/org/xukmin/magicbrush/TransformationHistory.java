package org.xukmin.magicbrush;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TransformationHistory {
  public void reset() {
    images.clear();
    index = -1;
  }
  
  public void add(BufferedImage image) {
    if (index < images.size() - 2) {
      images.subList(index + 1, images.size()).clear();
    }
    images.add(image);
    index++;
  }
  
  public void undo() {
    if (index > 0) {
      index--;
    }
  }
  
  public void redo() {
    if (index < images.size() - 2) {
      index++;
    }
  }
  
  public boolean isOldest() {
    return index <= 0;
  }
  
  public boolean isNewest() {
    return index >= images.size() - 2;
  }
  
 
  public BufferedImage lastImage() {
    if (index < 0 || index >= images.size()) {
      return null;
    } else {
      return images.get(index);
    }
  }
  
  public BufferedImage originalImage() {
    if (!images.isEmpty()) {
      return images.get(0);
    } else {
      return null;
    }
  }
  
  public BufferedImage oldImage() {
    if (index < 0) {
      return null;
    } else {
      return images.get(index);
    }
  }
  
  public BufferedImage newImage() {
    if (index > images.size() - 2) {
      return null;
    } else {
      return images.get(index + 1);
    }
  }
  
  private ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
  
  private int index = -1;
}
