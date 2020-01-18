package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Treatment {
	private ReadSymptomDataFromFile readData = new ReadSymptomDataFromFile("symptoms.txt");
	private List<String> symptomsFromFile = readData.getSymptoms();  
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
	
	public void writeElementInFile() throws IOException {
		FileWriter writer = new FileWriter ("result.out");
		for(int i =0;i<this.listedByOrder.size();i++) {
			writer.write(this.listedByOrder.get(i)
					+" : "
					+this.getDifferentSymptoms().get(this.listedByOrder.get(i))
					+"\n"
					);
		}
		writer.close();
		System.out.println("Le fichier a été enregistrer");
	}
}
