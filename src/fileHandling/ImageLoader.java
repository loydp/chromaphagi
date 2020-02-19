package fileHandling;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

	/**
	 * Loads an image.
	 */
	private BufferedImage image;

	public ImageLoader(String imgPath) {
		this.image = loadBufferedImage(imgPath);
	}

	public BufferedImage getImage() {
		return this.image;
	}

	// TODO remove boolean if it's never used.
	public boolean saveImage() {
		try {
			File outputfile = new File("aftermath.png");
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
         System.out.println(e);
		}
		return true;
	}

	/**
	 * Takes an image path as a string, and returns a buffered image (using
	 * ImageIO) from the file at the end of the path.
	 * @param imgPath the path to the image being loaded.
	 * @return BufferedImage using the filepath as the source.
	 */
	private BufferedImage loadBufferedImage(String imgPath) {
		try
		{
			return ImageIO.read(new File(imgPath));
		}
		catch (IOException e)
		{
			System.out.println(e + "... in loadBufferedImage(), ImageLoader.java");
			return null;
		}
	}
}