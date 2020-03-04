package chromaphagi;

import java.util.Random;

import lab.PetriDish;

public class MicrococcusLuteus extends Chromaphagi {

	Random rand;
	
	public MicrococcusLuteus(int x, int y) {
		super(x, y);
	}

	protected void deactivate() {
		PetriDish.unSetChromaphagi(x, y);
	}

	/**
	 * An active Chromaphagi will cycle through these stages within process():
	 * 1. Process information. (optional for a particular cycle)
	 * 2. Create the conditions of its own demise.
	 * 3. Check whether mitosis is appropriate.
	 * 4. if it is, do so.
	 * 5. Check if deactivation or destruction is necessary.
	 */
	public Chromaphagi process() {
		
		
		return this;
	}
	
	public void criticalProcess() {
		
	}

	// needs major work, currently starts from top.
	protected Chromaphagi mitosis() {
		int[] neighbor = getNeighbors();
		for (int i = 0; i < neighbor.length; i++) {
			if (neighbor[0] == 0)
				return new MicrococcusLuteus(x, y + 1);
			if (neighbor[1] == 0)
				return new MicrococcusLuteus(x + 1, y);
			if (neighbor[2] == 0)
				return new MicrococcusLuteus(x, y - 1);
			if (neighbor[3] == 0)
				return new MicrococcusLuteus(x - 1, y);
			}
		return null;
	}

	// Bit shifting in future
	private int[] getNeighbors() {
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
	
}