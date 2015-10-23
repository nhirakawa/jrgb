package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
            int returnVal = chooser.showOpenDialog(null);

            if(returnVal == JFileChooser.APPROVE_OPTION){
                File file = chooser.getSelectedFile();
                try {
                    BufferedImage image = ImageIO.read(file);
                    panel.setImage(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
