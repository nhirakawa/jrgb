package rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class GreenRGBStrategy implements RGBStrategy {
	@Override
	public Color convert(Color c) {
		int green = c.getGreen();
		return new Color(0, green, 0);
	}
}
