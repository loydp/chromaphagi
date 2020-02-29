package chromaphagi;

import java.util.Queue;

import lab.PetriDish;

public class SaccharomycesCerevisiae extends Chromaphagi {

	public SaccharomycesCerevisiae(int x, int y) {
		super(x, y);
		PetriDish.setChromaphagi(x, y);
	}

	/**
	 * The cell is polled from the queue and these things happen:
	 * 1. Location is checked
	 * 2. Depending on location, process completed
	 * 3. Depending on process, mitosis happens
	 * 4. Depending on mitosis, deletion from queue happens.
	 * @param edge
	 * @return
	 */
	public boolean act(Queue<Chromaphagi> edge) {
		if (!surrounded()) {
			process();
			mitosis(edge);
			return inActive();
		}
	}

	private boolean surrounded() {
		if (PetriDish.inDish(x + 1, y) && !PetriDish.isempty(x + 1, y)
			&& PetriDish.inDish(x - 1, y) && !PetriDish.isempty(x - 1, y)
			&& PetriDish.inDish(x, y + 1) && !PetriDish.isempty(x, y + 1)
			&& PetriDish.inDish(x, y - 1) && !PetriDish.isempty(x, y - 1)
		)
			return true;
		return false;
	}

	// TODO
	private boolean inActive() {
		return true;
	}

	void process() {

		int r = PetriDish.getChannel(x, y, 0);
		int g = PetriDish.getChannel(x, y, 1);
		int b = PetriDish.getChannel(x, y, 2);

		if (r < 100 && g < 100 && b < 100) {
			PetriDish.setChannels(x, y, 0, 0, 0);
		} else if (b > 175) {
			PetriDish.setChannels(x, y, 255, 0, 255);
		}
	}

	void mitosis(Queue<Chromaphagi> edge) {


		/*
		if (PetriDish.isempty(x + 1, y)) {
			edge.add(new SaccharomycesCerevisiae(x + 1, y));
		}
		*/

		// mitosis condition
		boolean up = PetriDish.inDish(x, y + 1);
		boolean right = PetriDish.inDish(x + 1, y);
		boolean down = PetriDish.inDish(x, y - 1);

		if (PetriDish.inDish(x, y + 1) && PetriDish.isempty(x, y + 1)) {
			edge.add(new SaccharomycesCerevisiae(x, y + 1));
			PetriDish.setChromaphagi(x, y + 1);
		}

		if (PetriDish.inDish(x + 1, y) && PetriDish.isempty(x + 1, y)) {
			edge.add(new SaccharomycesCerevisiae(x + 1, y));
			PetriDish.setChromaphagi(x + 1, y);
		}

	}
}