package lab;


// import java.awt.image.BufferedImage; what for

import fileHandling.ImageLoader;

/**
 * The point of entry for the program.
 */
public class Main {

	public final static String IMG_PATH = "src/dat/testimg.jpg";
	PetriDish petriDish;
	
	public static void main(String[] args) {
		ImageLoader imgLoader = new ImageLoader(IMG_PATH);
		PetriDish petriDish = new PetriDish(imgLoader.getImage());

		Lab lab = new Lab(petriDish);
		
		imgLoader.saveImage(petriDish.getImageArray());
		
	}

}