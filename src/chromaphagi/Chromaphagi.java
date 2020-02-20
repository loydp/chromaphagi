package chromaphagi;

public abstract class Chromaphagi {
	private int x;
	private int y;
	
	public Chromaphagi(int x, int y) {
		System.out.println("Test: chromaphagi reached.");
		this.x = x;
		this.y = y;
	}

	abstract void mitosis();
	
}
