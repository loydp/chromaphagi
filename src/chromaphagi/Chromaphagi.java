package chromaphagi;

import java.util.Queue;

import lab.PetriDish;

public abstract class Chromaphagi {

	protected int x;
	protected int y;

	public Chromaphagi(int x, int y) {
		this.x = x;
		this.y = y;
		PetriDish.setChromaphagi(x, y);
	}
	
	public abstract void process(int rand, int rand2, Queue<Chromaphagi> edge);
	
	protected abstract boolean consume();
	
	protected abstract Chromaphagi mitosis(int rand);

	protected int[] neighborsStatus() {
		int[] loc = {1, 1, 1, 1};
		if (PetriDish.inDish(x, y + 1) && PetriDish.isEmpty(x, y + 1))
			loc[0] = 0;
		if (PetriDish.inDish(x + 1, y) && PetriDish.isEmpty(x + 1, y))
			loc[1] = 0;
		if (PetriDish.inDish(x, y - 1) && PetriDish.isEmpty(x, y - 1))
			loc[2] = 0;
		if (PetriDish.inDish(x - 1, y) && PetriDish.isEmpty(x - 1, y))
			loc[3] = 0;
		return loc;
	}
	
	protected boolean surrounded() {
		if ((!PetriDish.inDish(x, y + 1) || !PetriDish.isEmpty(x, y + 1))
			&& (!PetriDish.inDish(x + 1, y) || !PetriDish.isEmpty(x + 1, y))
			&& (!PetriDish.inDish(x, y - 1) || !PetriDish.isEmpty(x, y - 1))
			&& (!PetriDish.inDish(x - 1, y) || !PetriDish.isEmpty(x - 1, y))) {
			return true;
		}
		return false;
	}

}