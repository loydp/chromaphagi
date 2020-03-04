package chromaphagi;

import java.util.LinkedList;
import java.util.Queue;

public class Culture {
	Queue<Chromaphagi> edge;
	
	public Culture(Chromaphagi c) {
		edge = new LinkedList<>();
		this.edge.add(c);
		System.out.println("culture activated");
	}

	public void activate() {
		while (!edge.isEmpty()) {
			Chromaphagi chph = edge.poll().process();
			if (!(chph == null))
				edge.add(chph);
		}
	}
	
	
	
}
