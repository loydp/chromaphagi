package lab;

import chromaphagi.CandidaMilleri;

/**
 * PetriDish holds a 3d array that contains a 
 * @author Owner
 *
 */
public class PetriDish {
	private static int[][][] img;
	private static int width;
	private static int height;
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public PetriDish(int[][][] img) {
		this.img = img;
		width = img.length;
		height = img[0].length;
	}

	public int[][][] getImageArray() {
		return img;
	}
	
	public static boolean inDish(int x, int y) {
		if (x < width && x >= 0 && y < height && y >= 0)
			return true;
		return false;
	}
	
	public static int getChannel(int x, int y, int z) {
		return img[x][y][z];
	}
	
	public static void setChannel(int x, int y, int z, int val) {
		img[x][y][z] = val;
	}
	
	public static void setChromaphagi(int x, int y) {
		img[x][y][3] = 1;
	}
	
	public static boolean isempty(int x, int y) {
		return (img[x][y][3] == 0);
	}
	
}