package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 * Created by nick on 10/22/15.
 */
public class RGBWindow extends JFrame{

    private RGBPanel panel;

    public RGBWindow(){
        super("jrgb");
        this.panel = new RGBPanel();

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu image = new JMenu("Image");
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(new OpenFileActionListener());
        file.add(open);


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
