package rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class RedRGBStrategy implements RGBStrategy {
	@Override
	public Color convert(Color c) {
		int red = c.getRed();
		return new Color(red, 0, 0);
	}
}
