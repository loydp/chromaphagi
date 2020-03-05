package chromaphagi;

import java.util.Queue;

import lab.PetriDish;


public class MicrococcusLuteus extends Chromaphagi {
	
	/**
	 * CTOR for this Chromaphagi. x & y are stored in the super class.
	 * @param x
	 * @param y
	 */
	public MicrococcusLuteus(int x, int y) {
		super(x, y);
	}

	/**
	 * An active Chromaphagi will cycle through these stages within process():
	 * 1. Process information. (optional for a particular cycle)
	 * 2. Create the conditions of its own demise.
	 * 3. Check whether mitosis is appropriate.
	 * 4. if it is, do so.
	 * 5. Check if deactivation or destruction is necessary.
	 */
	public void process(int rand, Queue<Chromaphagi> edge) {
		// process information and/or create conditions of demise
		boolean consumed = consume();
		
		if (consumed) {
			Chromaphagi chph = mitosis(rand);
			if (chph != null)
				edge.add(chph);
			chph = mitosis(rand);
			if (chph != null)
				edge.add(chph);
		}

		// deactivateCheck();
	}

	/**
	 * Processes the image in the characteristic manner of this Chromaphagi
	 * strain.
	 * @return a boolean representing if the cell has consumed
	 * color or not.
	 */
	private boolean consume() {
		int r = PetriDish.getChannel(x, y, 0);
		if (r < 100) {
			if (PetriDish.getChannel(x, y, 0) < 100)
				PetriDish.setChannels(x, y, 0, 0, 0);
		}
		
		if (PetriDish.getChannel(x, y, 0) > 100)
			PetriDish.setChannels(x, y, 255, 255, 255);
		if (r != 0 || r != 100)
			return true;
		return false;
	}
	
	/**
	 * Takes in a randomly generated number, and returns either a null, or
	 * the location of a new Chromaphagi to be created.
	 * @return Chromaphagi or a null, representing the location of a new CHPH.
	 * @throws InterruptedException 
	 */
	protected Chromaphagi mitosis(int rand) {
		int availableCount = 0;
		int[] neighbors = super.neighborsStatus();
		
		// TODO
		System.out.println(x + " " + y);
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] == 0)
				availableCount++;
		}
		
		// TODO
		for (int i = 0; i < neighbors.length; i++)
			System.out.print(neighbors[i] + " ");

		int direction = 0;
		
		if (availableCount != 0) {
			int randEmptyLoc = rand % availableCount;
			
			System.out.println("REL: " + randEmptyLoc);
			// Determine direction
			for (int i = 0; i < neighbors.length; i++) {
				// counts 0 - 4;
				if (neighbors[i] == 0) {
					if (randEmptyLoc == 0) {
						direction = i;
					}
				} else
					randEmptyLoc--;
			}
			
			// TODO
			System.out.println("direction: " + direction);
			
			switch(direction) {
			case 0:
				return new MicrococcusLuteus(x, y + 1);
			case 1:
				return new MicrococcusLuteus(x + 1, y);
			case 2:
				return new MicrococcusLuteus(x, y - 1);
			case 3:
				return new MicrococcusLuteus(x - 1, y);
			default:
				System.out.println("Should not get here");
					
			}
		}

		return null;
	}

	
	protected void deactivate() {
		PetriDish.unSetChromaphagi(x, y);
	}

	
}