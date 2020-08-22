package chromaphagi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Culture {
	private Queue<Chromaphagi> edge;
	private Random rand;
	
	public Culture(Chromaphagi chph) {
		edge = new LinkedList<>();
		this.edge.add(chph);
		rand = new Random();
	}
	
	/**
	 * Take the next chromaphagi on the queue and activate it.
	 */
	public boolean activate() {
		int r = rand.nextInt(128);
		int r2 = rand.nextInt(128);
		if (!edge.isEmpty())
			edge.poll().process(r, r2, edge);
		else
			edge.poll();
		if (edge.isEmpty())
			return false;
		return true;
	}
}



//while (!edge.isEmpty()) {