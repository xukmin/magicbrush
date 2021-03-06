// MagicBrush
// Author: Min Xu <xukmin@gmail.com>

package org.xukmin.magicbrush;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * This class is the Graphical User Interface of MagicBrush.
 */
public class MagicBrushGui {
  public static void main(String[] args) {
    String opSysName = System.getProperty("os.name").toLowerCase();
    if (opSysName.contains("mac")) {
      // Set the name of the app in the Mac App menu.
      System.setProperty("apple.awt.application.name", "MagicBrush");
      // Show the menu bar at the top of the screen.
      System.setProperty("apple.laf.useScreenMenuBar", "true");
      // Show a more mac-like file dialog box.
      System.setProperty("apple.awt.fileDialogForDirectories", "true");
      UIManager.getInstalledLookAndFeels();
    }
    
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        MagicBrushFrame frame = new MagicBrushFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}
