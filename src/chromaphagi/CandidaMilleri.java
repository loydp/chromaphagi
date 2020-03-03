package chromaphagi;

import java.util.Random;

import lab.PetriDish;

public class CandidaMilleri extends Chromaphagi {

	Random rand;
	
	public CandidaMilleri(int x, int y) {
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
		int[] neighbor = getNeighbors();
		
		if (r < 100) {
			if (neighbor[1] == 0 && PetriDish.getChannel(x, y, 0) < 100) {
				PetriDish.setChannels(x + 1, y, 100, 0, 0);
			}	
		}
		
		if (neighbor[3] == 0 && PetriDish.getChannel(x, y, 0) < 100)
			PetriDish.setChannels(x - 1, y, 155, 255, 255);
	}

	// needs major work, currently starts from top.
	protected Chromaphagi mitosis() {
		int[] neighbor = getNeighbors();
		for (int i = 0; i < neighbor.length; i++) {
			if (neighbor[0] == 0)
				return new CandidaMilleri(x, y + 1);
			if (neighbor[1] == 0)
				return new CandidaMilleri(x + 1, y);
			if (neighbor[2] == 0)
				return new CandidaMilleri(x, y - 1);
			if (neighbor[3] == 0)
				return new CandidaMilleri(x - 1, y);
			}
		return null;
	}


}