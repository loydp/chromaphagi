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
		System.out.println("culture activated");
		rand = new Random();
	}
	
	/**
	 * Take the next chromaphagi on the queue and activate it.
	 */
	public void activate() {
		//while (!edge.isEmpty()) {
		for (int i = 0; i < 100; i++) {
			int r = rand.nextInt(128);
			Chromaphagi chph = edge.poll();
			chph.process(r, edge);
		}
	}
}
