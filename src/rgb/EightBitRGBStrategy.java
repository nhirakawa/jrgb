package rgb;

import java.awt.*;

/**
 * Created by nick on 10/24/15.
 */
public class EightBitRGBStrategy implements RGBStrategy {
    @Override
    public Color convert(Color c) {
        int red = (int)Math.floor(c.getRed() / 32) * 32;
        int green = (int)Math.floor(c.getGreen() / 32) * 32;
        int blue = (int)Math.floor(c.getBlue() / 64) * 64;
        return new Color(red, green, blue);
    }
}
