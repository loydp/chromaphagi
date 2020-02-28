package chromaphagi;

import java.util.Queue;

public abstract class Chromaphagi {

	// Change to protected, get rid of get x/y?
	int x;
	int y;

	public int getX() {return x;}
	public int getY() {return y;}
	
	public Chromaphagi(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void act(Queue<Chromaphagi> colony);
}