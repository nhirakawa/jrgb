package com.github.nh0815.rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class InvertRGBStrategy extends RGBStrategy {

	@Override
	public int getRGB(int rgb) {
		Color c = new Color(rgb);
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		r = 255 - r;
		g = 255 - g;
		b = 255 - b;
		return new Color(r, g, b).getRGB();
	}

}
