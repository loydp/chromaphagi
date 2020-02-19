package chromaphagi;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Petri {

	// Commit
	BufferedImage image;
	Sourdough starter;

	public Petri(BufferedImage image) {
		this.image = image;
	}

	/**
	 * Infects center
	 */
	public void infect() {
		int h = (image.getHeight() / 2);
		int w = (image.getWidth() / 2);
		infect(w, h);
	}

	public void infect(int x, int y) {
		System.out.println(x + " " + y);
		Sourdough starter = new Sourdough(x, y);
	}

	/**
	 * Creates a self replicating organism.
	 * Takes a pixel, extracts colors and stores them.
	 * Then reads through the colors and makes actions based on that.
	 * Eventually ends itself.
	 */
	public class Sourdough {
		int x;
		int y;
		int pixel;
		int alpha;
		int red;
		int green;
		int blue;

		public Sourdough(int x, int y) {
			if (x < image.getWidth() - 1 || y < image.getHeight() - 1) {
				this.x = x;
				this.y = y;
				this.pixel = image.getRGB(x, y);
				this.red = (pixel & 0xff0000) >> 16;
				this.green = (pixel & 0x00ff00) >> 8;
				this.blue = pixel & 0x000000ff;
				System.out.println(pixel);

				if (blue > 40) {
					blue = blue/2;
					red = 255;
					green = 255;
					System.out.println("Next:");
					System.out.println(pixel);
					pixel = (red << 24) + (green << 16) + (blue << 8) + (alpha);
					System.out.println(pixel);
					new Sourdough(x + 3, y + 3);
					new Sourdough(x, y + 3);
					System.out.println("OK: " + x + " " + y + ": " + pixel);
				}
			}
		}
	}
}
