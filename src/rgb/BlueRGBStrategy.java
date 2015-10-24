package rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class BlueRGBStrategy implements RGBStrategy {
	@Override
	public Color convert(Color c) {
		int blue = c.getBlue();
		return new Color(0, 0, blue);
	}
}
