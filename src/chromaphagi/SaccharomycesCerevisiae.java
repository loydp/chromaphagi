package chromaphagi;

import java.util.Random;

import lab.PetriDish;

public class SaccharomycesCerevisiae extends Chromaphagi {

	Random rand;
	
	public SaccharomycesCerevisiae(int x, int y) {
		super(x, y);
	}

	// Bit shifting in future
	protected int[] getNeighbors() {
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

	// TODO
	protected void deactivate() {
		PetriDish.unSetChromaphagi(x, y);
	}

	protected void process() {

		int r = PetriDish.getChannel(x, y, 0);
		int g = PetriDish.getChannel(x, y, 1);
		int b = PetriDish.getChannel(x, y, 2);

		if (r < 100 && g < 100 && b < 100) {
			PetriDish.setChannels(x, y, 0, 0, 0);
		} else {
			PetriDish.setChannels(x, y, 255, 255, 255);
		}
		
		/*
		if (r < 100 && g < 100 && b < 100) {
			PetriDish.setChannels(x, y, 0, 0, 0);
		} else if (b > 175) {
			PetriDish.setChannels(x, y, 255, 0, 255);
		}
		*/
	}

	// needs major work, currently starts from top.
	protected Chromaphagi mitosis() {
		int[] neighbor = getNeighbors();
		for (int i = 0; i < neighbor.length; i++) {
			if (neighbor[0] == 0)
				return new SaccharomycesCerevisiae(x, y + 1);
			if (neighbor[1] == 0)
				return new SaccharomycesCerevisiae(x + 1, y);
			if (neighbor[2] == 0)
				return new SaccharomycesCerevisiae(x, y - 1);
			if (neighbor[3] == 0)
				return new SaccharomycesCerevisiae(x - 1, y);
			}
		return null;
	}


}