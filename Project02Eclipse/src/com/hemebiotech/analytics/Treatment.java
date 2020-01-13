package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public class Treatment {

	public Map<String, Integer> differentSymptoms = new HashMap<>();
	
	public void countSymptoms(String symptoms) {
		
		if(!this.differentSymptoms.containsKey(symptoms)){
			this.differentSymptoms.put(symptoms, 1);
		}else{
			this.differentSymptoms.replace(symptoms,this.differentSymptoms.get(symptoms)+1 );
		}
		
	}

}
