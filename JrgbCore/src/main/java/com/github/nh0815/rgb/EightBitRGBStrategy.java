package rgb;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by nick on 10/24/15.
 */
public class EightBitRGBStrategy extends RGBStrategy {

    @Override
    public int getRGB(int rgb) {
        Color c = new Color(rgb);
        int red = (int)Math.floor(c.getRed() / 32) * 32;
        int green = (int)Math.floor(c.getGreen() / 32) * 32;
        int blue = (int)Math.floor(c.getBlue() / 64) * 64;
        return new Color(red, green, blue).getRGB();
    }

}
