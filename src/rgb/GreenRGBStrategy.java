package rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class GreenRGBStrategy extends RGBStrategy {

	@Override
	public int getRGB(int rgb) {
		Color c = new Color(rgb);
		return new Color(0, c.getGreen(), 0).getRGB();
	}

	/*@Override
	public Color convert(Color c) {
		int green = c.getGreen();
		return new Color(0, green, 0);
	}*/
}
