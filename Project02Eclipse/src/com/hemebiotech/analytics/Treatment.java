package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public class Treatment {
	
	private int headacheCount = 0;	
	private int rashCount = 0;		
	private int pupilCount = 0;	
	private int feverCount = 0;
	
	public Map<String, Integer> differentSymptoms = new HashMap<>();
	
	public void countSymptoms(String symptoms) {
		if(!this.differentSymptoms.containsKey(symptoms)){
			this.differentSymptoms.put(symptoms, 0);
		}else{
			this.differentSymptoms.replace(symptoms,this.differentSymptoms.get(symptoms)+1 );
		}
	}

	public Map<String, Integer> getDifferentSymptoms() {
		return differentSymptoms;
	}

}
