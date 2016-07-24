package rgb;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by nick on 10/22/15.
 */
public abstract class RGBStrategy {

	public abstract int getRGB(int rgb);

	public BufferedImage convert(BufferedImage image){
		BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		for(int i = 0; i < image.getWidth(); i++){
			for(int j = 0; j < image.getHeight(); j++){
				int rgb = image.getRGB(i, j);
				result.setRGB(i, j, getRGB(rgb));
			}
		}
		return result;
	}

}
