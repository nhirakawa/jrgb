package rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class VanillaRGBStrategy implements RGBStrategy{


	@Override
	public Color convert(Color c) {
		return c;
	}
}
