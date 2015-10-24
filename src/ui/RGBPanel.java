package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by nick on 10/22/15.
 */
public class RGBPanel extends JPanel {

    private BufferedImage image;

    public RGBPanel(){
        super();
        setPreferredSize(new Dimension(600, 400));
        image = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
    }

    public void setImage(BufferedImage img){
        this.image = img;
        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        invalidate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

}
