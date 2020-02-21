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
		PetriDish petri = new PetriDish(imgLoader.getImage());
		
		petri.inoculate();
		
		imgLoader.saveImage();
	}

}