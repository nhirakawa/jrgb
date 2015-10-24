package rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class SepiaRGBStrategy implements RGBStrategy {
	@Override
	public Color convert(Color c) {
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();
		int outputRed = Math.min(255, (int)(red * 0.393) + (int)(green * 0.769) + (int)(blue * 0.189));
		int outputGreen = Math.min(255, (int)(red * 0.349) + (int)(green * 0.686) + (int)(blue * 0.168));
		int outputBlue = Math.min(255, (int)(red * 0.272) + (int)(green * 0.534) + (int)(blue * 0.131));
		return new Color(outputRed, outputGreen, outputBlue);
	}
}
