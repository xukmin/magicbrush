// MagicBrush
// Author: Min Xu <xukmin@gmail.com>

package org.xukmin.magicbrush;

import javax.swing.JFrame;

/**
 * 
 */
@SuppressWarnings("serial")
public class MagicBrushFrame extends JFrame {
  public MagicBrushFrame() {
    setTitle("MagicBrush");
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    add(new MagicBrushPanel(this));
    setLocationRelativeTo(null);
  }

  public static final int DEFAULT_WIDTH = 800;
  public static final int DEFAULT_HEIGHT = 600;
}

