package com.hemebiotech.analytics;


public class AnalyticsCounter {
		
	public static void main(String args[]) throws Exception {
		// first get input
		
		Treatment ourTreatment = new Treatment();
		
		ourTreatment.sortElement();

		//System.out.println(ourTreatment.getDifferentSymptoms());

		
		for(int i =0;i<ourTreatment.listedByOrder.size();i++) {
			System.out.println(ourTreatment.listedByOrder.get(i)
					+" : "
					+ourTreatment.getDifferentSymptoms().get(ourTreatment.listedByOrder.get(i))
					);
		}
		

		
		// next generate output
		/*FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();*/
		
		}
		
	}

