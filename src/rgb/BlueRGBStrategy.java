package rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class BlueRGBStrategy extends RGBStrategy {

	@Override
	public int getRGB(int rgb) {
		Color c = new Color(rgb);
		return new Color(0, 0, c.getBlue()).getRGB();
	}
}
