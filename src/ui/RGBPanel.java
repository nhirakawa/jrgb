package ui;

import rgb.InvertRGBStrategy;
import rgb.RGBStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by nick on 10/22/15.
 */
public class RGBPanel extends JPanel {

    private BufferedImage originalImage;
    private BufferedImage image;
    private RGBStrategy converter;

    public RGBPanel(){
        this(new InvertRGBStrategy());
    }

    public RGBPanel(RGBStrategy converter){
        super();
        this.converter = converter;
        setPreferredSize(new Dimension(600, 400));
//        image = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
//        originalImage = image;
    }

    public void setRGBStrategy(RGBStrategy strategy){
        this.converter = strategy;
    }

    public void convert(){
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i < originalImage.getWidth(); i++){
            for(int j = 0; j < originalImage.getHeight(); j++){
                Color color = new Color(originalImage.getRGB(i, j));
                color = converter.convert(color);
                newImage.setRGB(i, j, color.getRGB());
            }
        }
        image = newImage;
        invalidate();
        repaint();
    }

    public void setImage(BufferedImage img){
        this.originalImage = img;
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
