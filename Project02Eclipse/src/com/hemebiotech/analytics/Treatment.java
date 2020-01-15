package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public class Treatment {

	private Map<String, Integer> differentSymptoms = new HashMap<>();
	
	public void countSymptoms(String symptoms) {
		
			if(!this.differentSymptoms.containsKey(symptoms)){
				this.differentSymptoms.put(symptoms, 1);
			}else{
				this.differentSymptoms.replace(symptoms,this.differentSymptoms.get(symptoms)+1 );
			}	
	}
	
	//CREER UNE FONCTION QUI ORDONNE ELEMENTS PAR ORDRE ALPHABETIQUE et une fonction pour ecrire dans File

	public Map<String, Integer> getDifferentSymptoms() {
		return differentSymptoms;
	}
}
