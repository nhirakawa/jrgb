package rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class InvertRGBStrategy implements RGBStrategy {

	@Override
	public Color convert(Color c) {
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		r = 255 - r;
		g = 255 - g;
		b = 255 - b;
		return new Color(r, g, b);
	}

}
