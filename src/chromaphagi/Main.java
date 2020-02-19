package chromaphagi;

import fileHandling.FileHandling;

// import java.awt.image.BufferedImage; what for

/**
 * The point of entry for the program.
 */
public class Main {

	public final static String IMG_PATH = "src/dat/testimg.jpg";

	
	public static void main(String[] args) {
		FileHandling fHandle = new FileHandling(IMG_PATH);

		System.out.println("fHandle made");
	}

}