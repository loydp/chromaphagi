package fileHandling;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
	private BufferedImage bufferedImage;
	private int[][][] imageArray;
	private int height;
	private int width;
	private final int Z_AXIS = 3;
	
	public ImageLoader(String imgPath) {
		this.bufferedImage = loadBufferedImage(imgPath);
		height = bufferedImage.getHeight();
		width = bufferedImage.getWidth();
		imageToArray();
	}

	/**
	 * Takes a buffered image and turns it into a three dimensional array
	 * containing rgb color channels on the z axis.
	 */
	private void imageToArray() {
		int pixel;
		int[][][] imgArr = new int[width][height][Z_AXIS];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pixel = bufferedImage.getRGB(i, j);
				imgArr[i][j][0] = (pixel >> 16) & 0xFF;
				imgArr[i][j][1] = (pixel >> 8) & 0xFF;
				imgArr[i][j][2] = pixel & 0xFF;
			}
		}
		imageArray = imgArr;
	}
	
	public int[][][] getImage() {
		return imageArray;
	}

	// TODO remove boolean if it's never used.
	public boolean saveImage() {
		int pixel;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pixel = imageArray[i][j][0];
				pixel = (pixel << 8) + imageArray[i][j][1];
				pixel = (pixel << 8) + imageArray[i][j][2];
			}
		}
		
		try {
			File outputfile = new File("aftermath.png");
			ImageIO.write(bufferedImage, "png", outputfile);
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