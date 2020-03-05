package lab;

import chromaphagi.Chromaphagi;
import chromaphagi.Culture;
import chromaphagi.MicrococcusLuteus;


public class Lab {
	PetriDish petriDish;
	
	public Lab(PetriDish petriDish) {
		
		Chromaphagi chph1 = new MicrococcusLuteus(PetriDish.getHeight() /2, PetriDish.getWidth() /2);
		
		Culture culture1 = new Culture(chph1);
		
		culture1.activate();
		
		System.out.println("pixel 100 x 100 has no chromaphagi: " + PetriDish.isEmpty(70, 70));
		// hack
		for (int i = 0; i < PetriDish.getWidth(); i++) {
			for (int j = 0; j < PetriDish.getHeight(); j++) {
				PetriDish.unSetChromaphagi(i, j);
			}
		}
		
		System.out.println("pixel 100 x 100 has no chromaphagi: " + PetriDish.isEmpty(100, 100));
		
		System.out.println();
		
	}
	

}
