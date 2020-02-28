package lab;

import java.util.LinkedList;
import java.util.Queue;

import chromaphagi.CandidaMilleri;
import chromaphagi.Chromaphagi;

public class Lab {
	PetriDish petriDish;
	
	public Lab(PetriDish petriDish) {
		this.petriDish = petriDish;
		
		Chromaphagi cm = new CandidaMilleri(petriDish.getWidth() / 2,
															petriDish.getHeight() / 2);
		
		Queue<Chromaphagi> colony = new LinkedList<>();
		colony.add(cm);
		
		// continuously loops through the edge of the chromaphagi colony.
		while (!colony.isEmpty()) {
			colony.poll().act(colony);
		}
	}

}
