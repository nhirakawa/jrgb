package com.github.nh0815.jrgb.ui;

import com.github.nh0815.jrgb.RgbConverter;
import com.github.nh0815.jrgb.rgb.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.*;

public class RgbWindow extends JFrame{

    private RgbPanel panel;
    private RgbConverter converter;

    public RgbWindow(){
        super("jrgb");
        this.converter = new RgbConverter();
        this.panel = new RgbPanel(converter);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Could not set UI look and feel");
        }

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu image = new JMenu("Image");
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(new OpenFileActionListener());
        file.add(open);

        JMenuItem original = new JMenuItem("Original");
        original.addActionListener(new OriginalActionListener());
        image.add(original);

        JMenuItem invert = new JMenuItem("Invert");
        invert.addActionListener(new InvertActionListener());
        image.add(invert);

        JMenuItem sepia = new JMenuItem("Sepia");
        sepia.addActionListener(new SepiaActionListener());
        image.add(sepia);

        JMenuItem eightBit = new JMenuItem("EightBit");
        eightBit.addActionListener(new EightBitActionListener());
        image.add(eightBit);

        JMenuItem red = new JMenuItem("Red");
        red.addActionListener(new RedActionListener());
        image.add(red);
        JMenuItem green = new JMenuItem("Green");
        green.addActionListener(new GreenActionListener());
        image.add(green);
        JMenuItem blue = new JMenuItem("Blue");
        blue.addActionListener(new BlueActionListener());
        image.add(blue);

        menuBar.add(file);
        menuBar.add(image);
        setJMenuBar(menuBar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setVisible(true);
    }

    private class OpenFileActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new ImageFilter());
            int returnVal = chooser.showOpenDialog(null);

            if(returnVal == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                try {
                    BufferedImage image = ImageIO.read(file);
                    panel.setImage(image);
                    pack();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class OriginalActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            converter.setRgbStrategy(new IdentityRGBStrategy());
            panel.convert();
        }
    }

    private class InvertActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            converter.setRgbStrategy(new InvertRGBStrategy());
            panel.convert();
        }
    }

    private class SepiaActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            converter.setRgbStrategy(new SepiaRGBStrategy());
            panel.convert();
        }
    }

    private class EightBitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            converter.setRgbStrategy(new EightBitRGBStrategy());
            panel.convert();
        }
    }

    private class RedActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            converter.setRgbStrategy(new RedRGBStrategy());
            panel.convert();
        }
    }

    private class GreenActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            converter.setRgbStrategy(new GreenRGBStrategy());
            panel.convert();
        }
    }

    private class BlueActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            converter.setRgbStrategy(new BlueRGBStrategy());
            panel.convert();
        }
    }

    private static class ImageFilter extends FileFilter {

        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }

            String extension = Utils.getExtension(f);
            if (extension != null) {
                if (extension.equals(Utils.tiff) ||
                        extension.equals(Utils.tif) ||
                        extension.equals(Utils.gif) ||
                        extension.equals(Utils.jpeg) ||
                        extension.equals(Utils.jpg) ||
                        extension.equals(Utils.png)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        public String getDescription() {
            return "Just Images";
        }
    }

    private static class Utils {

        public final static String jpeg = "jpeg";
        public final static String jpg = "jpg";
        public final static String gif = "gif";
        public final static String tiff = "tiff";
        public final static String tif = "tif";
        public final static String png = "png";

        /*
         * Get the extension of a file.
         */
        public static String getExtension(File f) {
            String ext = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 &&  i < s.length() - 1) {
                ext = s.substring(i+1).toLowerCase();
            }
            return ext;
        }
    }
}
