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
	private List<String> listedByOrder = new ArrayList<String>(); //pour trier par ordre alphabétique ensuite
	

	
	/**
	 * This method will save element as a key with a value which represent the number 
	 * of symptoms(work like a counter)
	 * 
	 * @param symptoms
	 */
	private void countSymptoms(String symptoms) {
		
			if(!this.differentSymptoms.containsKey(symptoms)){
				this.differentSymptoms.put(symptoms, 1);
				this.listedByOrder.add(symptoms);
			}else{
				this.differentSymptoms.replace(symptoms,this.differentSymptoms.get(symptoms)+1 );
			}	
	}
	
	
/**
 * In this method, we will sort element by alphabetic order
 */
	public void sortElement() {
		for(int i = 0;i<this.symptomsFromFile.size();i++) {				
			this.countSymptoms(this.symptomsFromFile.get(i));
		}
		Collections.sort(this.listedByOrder);	//les trier par ordre alphabétique
	}
	
	/**
	 * This method will write in "result.out" file and if it's the last line it will finish
	 * with a "." else it will finish with a ";" in the file
	 * @throws IOException
	 */
	public void writeElementInFile(){
		if(this.symptomsFromFile.size()>0) {
			try {
				FileWriter writer = new FileWriter ("result.out");
				for(int i =0;i<this.listedByOrder.size();i++) {
					if(i==this.listedByOrder.size()-1) {
						writer.write(this.listedByOrder.get(i)
								+" = "
								+this.differentSymptoms.get(this.listedByOrder.get(i))
								+"."
								);
					}else {
						writer.write(this.listedByOrder.get(i)
								+" = "
								+this.differentSymptoms.get(this.listedByOrder.get(i))
								+";\n"
								);
					}
				}
				writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				System.out.println("Le fichier a bien été enregistré");
			}
		}
	}
}
