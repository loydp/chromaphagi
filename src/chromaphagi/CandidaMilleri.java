package chromaphagi;

import java.util.Queue;

import lab.PetriDish;


public class CandidaMilleri extends Chromaphagi {
	
	/**
	 * CTOR for this Chromaphagi. x & y are stored in the super class.
	 * @param x
	 * @param y
	 */
	public CandidaMilleri(int x, int y) {
		super(x, y);
		//TODO  System.out.println("CHPH: " + x + " " + y);
	}

	/**
	 * An active Chromaphagi will cycle through these stages within process():
	 * 1. Process information. (optional for a particular cycle)
	 * 2. Create the conditions of its own demise.
	 * 3. Check whether mitosis is appropriate.
	 * 4. if it is, do so.
	 * 5. Check if deactivation or destruction is necessary.
	 */
	public void process(int rand, int rand2, Queue<Chromaphagi> edge) {
		boolean consumed = consume();
		if (!surrounded()) {
   		
   		if (consumed) {
   			Chromaphagi chph = mitosis(rand);
   			if (chph != null) {
   				edge.add(chph);
   			}
   			if (rand < 30) {
   				chph = mitosis(rand2);
      			if (chph != null)
      				edge.add(chph);
   			}
   		}
		}
	}

	/**
	 * Processes the image in the characteristic manner of this Chromaphagi
	 * strain. May also alter energy levels.
	 * @return a boolean representing if the cell has consumed
	 * color or not.
	 */
	protected boolean consume() {
		int r = PetriDish.getChannel(x, y, 0);
		int g = PetriDish.getChannel(x, y, 1);
		int b = PetriDish.getChannel(x, y, 2);
		
		if (g < 100 && r > 50) {
			PetriDish.setChannels(x, y, 200, g/2 + r/2/2, 200);
		}
		
		if (r < 100 && g > 50) {
			PetriDish.setChannels(x, y, r/2 + r/2/2, 200, 200);
		}
		
		if (b < 60)
			PetriDish.setChannels(x, y, 0 + r/2/2, 0 + g/2/2, 0);
		
		if (r > 200 || g > 200)
			return false;
		return true;
	}
	
	/**
	 * Takes in a randomly generated number, and returns either a null, or
	 * the location of a new Chromaphagi to be created.
	 * @return Chromaphagi or a null, representing the location of a new CHPH.
	 * @throws InterruptedException 
	 */
	protected Chromaphagi mitosis(int rand) {
		int availableCount = 0;
		int[] neighbors = neighborsStatus();
		
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] == 0)
				availableCount++;
		}
		
		// BUGFIXING GOOD STUFF
		//for (int i = 0; i < neighbors.length; i++)
		//	System.out.print(neighbors[i] + " ");

		int direction = 0;
		
		if (availableCount != 0) {
			int randEmptyLoc = rand % availableCount;

			// BUGFIXING GOOD STUFF
			//System.out.println("Rand" + rand);
			// System.out.println("REL: " + randEmptyLoc);

			for (int i = 0; i < neighbors.length; i++) {
				if (neighbors[i] == 0) {
					if (randEmptyLoc == 0) {
						direction = i;
					}
					randEmptyLoc--;
				}
			}
			
			// BUGFIXING GOOD STUFF
			// System.out.println("direction: " + direction);
			
			switch(direction) {
			case 0:
				return new CandidaMilleri(x, y + 1);
			case 1:
				return new CandidaMilleri(x + 1, y);
			case 2:
				return new CandidaMilleri(x, y - 1);
			case 3:
				return new CandidaMilleri(x - 1, y);
			default:
				System.out.println("ALERT: Problem in Mitosis, SWITCH");
					
			}
		}
		return null;
	}
	
}