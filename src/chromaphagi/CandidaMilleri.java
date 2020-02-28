package chromaphagi;

import java.util.LinkedList;
import java.util.Queue;

import lab.PetriDish;

public class CandidaMilleri extends Chromaphagi {

	public CandidaMilleri(int x, int y) {
		super(x, y);
		PetriDish.setChromaphagi(x, y);
	}
	
	public void act(Queue<Chromaphagi> edge) {
		process();
		mitosis(edge);
	}

	void process() {
		int x = super.getX();
		int y = super.getY();
		if (PetriDish.getChannel(x, y, 0) < 100) {
			PetriDish.setChannel(x, y, 0, 255);
			PetriDish.setChannel(x, y, 1, 255);
			PetriDish.setChannel(x, y, 2, 255);
		} else {
			PetriDish.setChannel(x, y, 0, 0);
			PetriDish.setChannel(x, y, 1, 0);
			PetriDish.setChannel(x, y, 2, 0);
		}
	}

	void mitosis(Queue<Chromaphagi> edge) {
		int x = super.getX();
		int y = super.getY();
		if (PetriDish.inDish(x, y + 1) && PetriDish.isempty(x, y + 1)) {
			edge.add(new CandidaMilleri(x, y + 1));
			PetriDish.setChromaphagi(x, y + 1);
		}
		if (PetriDish.inDish(x + 1, y) && PetriDish.isempty(x + 1, y)) {
			edge.add(new CandidaMilleri(x + 1, y));
			PetriDish.setChromaphagi(x + 1, y);
		}
	}

}
