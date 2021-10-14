package com.github.nhirakawa.jrgb.rgb;

/**
 * Created by Nick on 10/23/2015.
 */
public class IdentityRGBStrategy extends RGBStrategy{

	@Override
	public int getRGB(int rgb) {
		return rgb;
	}
}
