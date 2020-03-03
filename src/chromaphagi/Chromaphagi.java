package chromaphagi;

import java.util.Queue;

import lab.PetriDish;

public abstract class Chromaphagi {

	// Change to protected, get rid of get x/y?
	int x;
	int y;
/*
	public int getX() {return x;}
	public int getY() {return y;}
*/
	public Chromaphagi(int x, int y) {
		this.x = x;
		this.y = y;
		PetriDish.setChromaphagi(x, y);
	}

	protected abstract void deactivate();

	private abstract int[] getNeighbors();

	protected abstract Chromaphagi mitosis();

	public abstract Chromaphagi process();

}