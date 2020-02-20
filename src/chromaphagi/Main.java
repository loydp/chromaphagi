package chromaphagi;

// import java.awt.image.BufferedImage; what for

import fileHandling.ImageLoader;

/**
 * The point of entry for the program.
 */
public class Main {

	public final static String IMG_PATH = "src/dat/testimg.jpg";

	public static void main(String[] args) {
		ImageLoader imgLoader = new ImageLoader(IMG_PATH);
		int[][][] ok = imgLoader.getImage();
		PetriDish petri = new PetriDish(ok);
		imgLoader.saveImage();
		System.out.println("fHandle made");
	}

}