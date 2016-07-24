package com.github.nh0815.jrgb;

import com.github.nh0815.jrgb.rgb.IdentityRGBStrategy;
import com.github.nh0815.jrgb.rgb.RGBStrategy;

import java.awt.image.BufferedImage;

public class RgbConverter {

    private RGBStrategy strategy;

    public RgbConverter() {
        this(new IdentityRGBStrategy());
    }

    public RgbConverter(RGBStrategy strategy) {
        this.strategy = strategy;
    }

    public BufferedImage convert(BufferedImage image) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                int rgb = image.getRGB(i, j);
                result.setRGB(i, j, strategy.getRGB(rgb));
            }
        }
        return result;
    }

    public void setRgbStrategy(RGBStrategy strategy){
        this.strategy = strategy;
    }

}
