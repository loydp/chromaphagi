package lab;

import chromaphagi.CandidaMilleri;
import chromaphagi.Chromaphagi;
import chromaphagi.Culture;
import chromaphagi.MicrococcusLuteus;


public class Lab {
	PetriDish petriDish;
	
	public Lab(PetriDish petriDish) {
		// PetriDish.getHeight() /2, PetriDish.getWidth() /2
		Chromaphagi chph1 = new MicrococcusLuteus(PetriDish.getHeight() /2 - 300, PetriDish.getWidth() /2 - 200);
		//Culture culture1 = new Culture(chph1);
		Culture culture1 = new Culture(chph1);
		Chromaphagi milleri = new CandidaMilleri(PetriDish.getHeight() /2 - 400, PetriDish.getWidth() /2 - 200);
		// Culture culture2 = new Culture(milleri);
		Culture culture2 = new Culture(milleri);
		
		boolean go1 = true;
		boolean go2 = true;
		int counter = 1;
		// TODO overload Culture.java
		while (go1 && go2) {
			go1 = culture1.activate();
			//if (counter % 2 == 0)
			//	go2 = culture1.activate();
			//counter++;
		}
		/*
		culture1.activate();
		refresh();
		culture2.activate();
		*/
		
		System.out.println();
		
	}
	

	public void refresh() {
		for (int i = 0; i < PetriDish.getWidth(); i++) {
			for (int j = 0; j < PetriDish.getHeight(); j++) {
				PetriDish.unSetChromaphagi(i, j);
			}
		}
	}
}
