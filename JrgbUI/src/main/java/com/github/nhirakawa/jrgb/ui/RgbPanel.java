package com.github.nhirakawa.jrgb.ui;

import com.github.nhirakawa.jrgb.RgbConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by nick on 10/22/15.
 */
public class RgbPanel extends JPanel {

    private BufferedImage originalImage;
    private BufferedImage image;
    private RgbConverter converter;

    public RgbPanel(RgbConverter converter){
        super();
        this.converter = converter;
        setPreferredSize(new Dimension(600, 400));
    }

    public void convert(){
        image = converter.convert(originalImage);
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
