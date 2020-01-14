package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class AnalyticsCounter {
		
	public static void main(String args[]) throws Exception {
		// first get input
		ReadSymptomDataFromFile readData = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomsFromFile = readData.GetSymptoms();  
		Treatment ourTreatment = new Treatment();
		
		for(int i = 0;i<symptomsFromFile.size();i++) {				
			ourTreatment.countSymptoms(symptomsFromFile.get(i));
		}

		System.out.println(ourTreatment.getDifferentSymptoms());
		
		//TEST PERSONNELS
		int total=0;
		for(Entry<String, Integer> element : ourTreatment.getDifferentSymptoms().entrySet()) {
			total+= element.getValue();
		}
		
		System.out.println(total);
		
		// next generate output
		/*FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
		
		}
		
	}

