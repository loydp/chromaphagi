package lab;

import chromaphagi.CandidaMilleri;
import chromaphagi.Chromaphagi;
import chromaphagi.Culture;
import chromaphagi.MicrococcusLuteus;
import chromaphagi.SaccharomycesCerevisiae;

public class Lab {
	PetriDish petriDish;
	
	public Lab(PetriDish petriDish) {
		
		Chromaphagi chph1 = new MicrococcusLuteus(PetriDish.getHeight() /2, PetriDish.getWidth() /2);
		
		Culture culture1 = new Culture(chph1);
		
		culture1.activate();
		
		System.out.println(PetriDish.isEmpty(100, 100));
		// hack
		for (int i = 0; i < PetriDish.getWidth(); i++) {
			for (int j = 0; j < PetriDish.getHeight(); j++) {
				PetriDish.unSetChromaphagi(i, j);
			}
		}
		System.out.println(PetriDish.isEmpty(100, 100));
		
		Chromaphagi chph2 = new MicrococcusLuteus(PetriDish.getHeight() /2, PetriDish.getWidth() /2);
		
		Culture culture2 = new Culture(chph2);
		
		culture2.activate();
		
		
		
	}
}
