package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Treatment {
	public ReadSymptomDataFromFile readData = new ReadSymptomDataFromFile("symptoms.txt");
	public List<String> symptomsFromFile = readData.getSymptoms();  
	private Map<String, Integer> differentSymptoms = new HashMap<>();
	public List<String> listedByOrder = new ArrayList<String>();; 
	
	public void countSymptoms(String symptoms) {
		
			if(!this.differentSymptoms.containsKey(symptoms)){
				this.differentSymptoms.put(symptoms, 1);
				this.listedByOrder.add(symptoms);
			}else{
				this.differentSymptoms.replace(symptoms,this.differentSymptoms.get(symptoms)+1 );
			}	
	}
	
	//CREER UNE FONCTION QUI ORDONNE ELEMENTS PAR ORDRE ALPHABETIQUE et une fonction pour ecrire dans File

	public void sortElement() {
		for(int i = 0;i<this.symptomsFromFile.size();i++) {				
			this.countSymptoms(this.symptomsFromFile.get(i));
		}
		Collections.sort(this.listedByOrder);	//les trier par ordre alphabétique
	}
	
	public Map<String, Integer> getDifferentSymptoms() {
		return differentSymptoms;
	}
}
