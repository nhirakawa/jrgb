package com.github.nhirakawa.jrgb.rgb;

import java.awt.*;

/**
 * Created by Nick on 10/23/2015.
 */
public class RedRGBStrategy extends RGBStrategy {

	@Override
	public int getRGB(int rgb) {
		Color c = new Color(rgb);
		return new Color(c.getRed(), 0, 0).getRGB();
	}

}
