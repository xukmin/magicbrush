package org.xukmin.magicbrush;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 
 */
@SuppressWarnings("serial")
public class MagicBrushPanel extends JPanel {
  public MagicBrushPanel(JFrame frame) {
    this.frame = frame;
    setLayout(new BorderLayout());

    JButton openButton = new JButton("Open...");
    JButton saveButton = new JButton("Save...");
    JButton resetButton = new JButton("Reset...");
    JButton undoButton = new JButton("Undo");
    JButton redoButton = new JButton("Redo");
    JButton exitButton = new JButton("Exit...");
    
    openButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MagicBrushPanel.this.open();
      }
    });
    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MagicBrushPanel.this.save();
      }
    });
    resetButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MagicBrushPanel.this.reset();
      }
    });
    undoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MagicBrushPanel.this.undo();
      }
    });
    redoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MagicBrushPanel.this.redo();
      }
    });  
    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MagicBrushPanel.this.exit();
      }
    });
    
    JPanel basicButtons = new JPanel();
    basicButtons.setBorder(BorderFactory.createTitledBorder("Basic Actions"));
    basicButtons.setLayout(new GridLayout(1, 0));
    basicButtons.add(openButton);
    basicButtons.add(saveButton);
    basicButtons.add(resetButton);
    basicButtons.add(undoButton);
    basicButtons.add(redoButton);
    basicButtons.add(exitButton);
    
    
    // Create buttons
    JButton mirrorButton = new JButton("Mirror");
    JButton upsideDownButton = new JButton("Upside Down");
    JButton wobbleButton = new JButton("Wobble");
    JButton colorInvertButton = new JButton("Color Invert");
    JButton grayScaleButton = new JButton("Gray Scale");
    JButton colorCastButton = new JButton("Color Cast");
    JButton recolorButton = new JButton("Recolor");
    JButton enhanceButton = new JButton("Enhance");
    JButton blurButton = new JButton("Blur");
    JButton coloredDotsButton = new JButton("Colored Dots");
    
    mirrorButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new MirrorTransformerConfigurator(MagicBrushPanel.this));
      }
    });
    upsideDownButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new UpsideDownTransformerConfigurator(MagicBrushPanel.this));
      }
    });
    wobbleButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new WobbleTransformerConfigurator(MagicBrushPanel.this));
      }
    });
    colorInvertButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new ColorInvertTransformerConfigurator(MagicBrushPanel.this));
      }
    });
    grayScaleButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new GrayScaleTransformerConfigurator(MagicBrushPanel.this));
      }
    });
    colorCastButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new ColorCastTransformerConfigurator(MagicBrushPanel.this));
      }
    });   
    recolorButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new RecolorTransformerConfigurator(MagicBrushPanel.this));
      }
    });
    enhanceButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new ColorEnhanceTransformerConfigurator(MagicBrushPanel.this));
      }
    });
    blurButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new BlurTransformerConfigurator(MagicBrushPanel.this));
      }
    });
    coloredDotsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setConfigurator(new ColoredDotsTransformerConfigurator(MagicBrushPanel.this));
      }     
    });

    transformationButtons = new JPanel();
    transformationButtons.setBorder(BorderFactory.createTitledBorder("Image Transformations"));
    transformationButtons.setLayout(new GridLayout(2, 0));
    transformationButtons.add(mirrorButton);
    transformationButtons.add(upsideDownButton);
    transformationButtons.add(wobbleButton);
    transformationButtons.add(colorInvertButton);
    transformationButtons.add(grayScaleButton);
    transformationButtons.add(colorCastButton);
    transformationButtons.add(recolorButton);
    transformationButtons.add(enhanceButton);
    transformationButtons.add(blurButton);
    transformationButtons.add(coloredDotsButton);
    setEnabledForTransformationButtons(false);

    JPanel buttons = new JPanel();
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
    buttons.add(basicButtons);
    buttons.add(transformationButtons);
    
    add(buttons, BorderLayout.PAGE_START);
    
    oldImageIcon = new ImageIcon();
    newImageIcon = new ImageIcon();

    oldImagePane = new JScrollPane(new JLabel(oldImageIcon));
    newImagePane = new JScrollPane(new JLabel(newImageIcon));
    
    Dimension imagePaneSize = new Dimension(640, 480);
    oldImagePane.setMaximumSize(imagePaneSize);
    newImagePane.setMaximumSize(imagePaneSize);
    
    oldImagePane.setPreferredSize(imagePaneSize);
    newImagePane.setPreferredSize(imagePaneSize);
    
    imagesPanel = new JPanel();
    imagesPanel.setLayout(new GridLayout(1, 2));
    imagesPanel.add(oldImagePane);
    
    add(imagesPanel, BorderLayout.CENTER);
  }

  public BufferedImage getOldImage() {
    return (BufferedImage) oldImageIcon.getImage();
  }
  
  public void setOldImage(BufferedImage image) {
    oldImageIcon.setImage(image);
    oldImagePane.revalidate();
    oldImagePane.repaint();
  }
  
  public BufferedImage getNewImage() {
    return (BufferedImage) newImageIcon.getImage();
  }
  
  public void setNewImage(BufferedImage image) {
    newImageIcon.setImage(image);
    newImagePane.revalidate();
    newImagePane.repaint();
  }
  
  public void removeNewImage() {
    imagesPanel.remove(newImagePane);
    imagesPanel.revalidate();
  }
  
  public void pushOldImage() {
    if (imagesPanel.getComponents().length == 1) {
      imagesPanel.add(newImagePane);
      imagesPanel.revalidate();
    } else {
      setOldImage(getNewImage());
    }
  }

  public void setConfigurator(Component component) {
    Component old_configurator =
        ((BorderLayout) getLayout()).getLayoutComponent(BorderLayout.PAGE_END);
    if (old_configurator != null) {
      remove(old_configurator);
    }
    
    if (component != null) {
      add(component, BorderLayout.PAGE_END);
    }

    frame.revalidate();
  }
 
  private void setEnabledForTransformationButtons(boolean b) {
    for (Component component : transformationButtons.getComponents()) {
      component.setEnabled(b);
    }
  }
  
  private void open() {
    JFileChooser fileChooser = new JFileChooser();
    int response = fileChooser.showOpenDialog(frame);
    if (response == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      try {
        if (imagesPanel.getComponents().length == 2) {
          imagesPanel.remove(newImagePane);
          imagesPanel.revalidate();
        }
        setOldImage(ImageIO.read(file));
        history.reset();
        history.add(getOldImage());
        setEnabledForTransformationButtons(true);
      } catch (IOException ex) {
        // FIXME
        System.exit(1);
      }
    }
  }
  
  private void save() {
    BufferedImage image = getNewImage();
    if (image == null) {
      image = getOldImage();
    }
    if (image == null) {
      // FIXME: show "There is no image to save."
      return;
    }

    JFileChooser fileChooser = new JFileChooser();
    int response = fileChooser.showSaveDialog(frame);
    if (response == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();          
      try {
        // TODO: Save in the same file type as original input.
        ImageIO.write(image, "jpg", file);
      } catch (IOException ex) {
        // FIXME
        System.exit(1);
      }
    }
  }

  private void reset() {
    int response = JOptionPane.showConfirmDialog(
        frame,
        "Are you sure to reset MagicBrush?",
        "Confirmation",
        JOptionPane.YES_NO_OPTION);
    if (response != 0) {
      return;
    }
    
    removeNewImage();
    if (history.originalImage() != null) {
      setConfigurator(null);
      setOldImage(history.originalImage());
      history.reset();
      history.add(getOldImage());
    }
  }
  
  private void undo() {
    if (history.isOldest()) {
      if (imagesPanel.getComponents().length == 1) {
        return;
      }
      removeNewImage();
    }
    setConfigurator(null);
    if (history.newImage() == null) {
      history.add(getNewImage());
      history.undo();
    }
    history.undo();
    if (history.isOldest()) {
      if (getOldImage() != null) {
        removeNewImage();
      }
    } else {
      setNewImage(getOldImage());
      setOldImage(history.oldImage());
    }
  }

  private void redo() {
    if (history.isNewest()) {
      return;
    }
    setConfigurator(null);
    history.redo();
    pushOldImage();
    setNewImage(history.newImage());
  }
  
  private void exit() {
    int response = JOptionPane.showConfirmDialog(
        frame,
        "Are you sure to exit MagicBrush?",
        "Confirmation",
        JOptionPane.YES_NO_OPTION);
    if (response == 0) {
      frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }    
  }
  
  JFrame frame;
  JPanel transformationButtons;
  JPanel imagesPanel;
  JScrollPane oldImagePane;
  JScrollPane newImagePane;
  ImageIcon oldImageIcon;
  ImageIcon newImageIcon;
  
  TransformationHistory history = new TransformationHistory();
}

