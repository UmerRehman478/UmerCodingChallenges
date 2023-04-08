package oosequence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;

public class Itinerary extends TripComponent{
	private ArrayList<TripComponent> tripcomponents= new ArrayList<TripComponent>();
	private String name;

	public Itinerary(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
		

	public ArrayList<TripComponent> getTripComponents() {
		// TODO Auto-generated method stub
		return tripcomponents;
		
	}

	public void addTripComponent(TripComponent aComponent) {	
		if(tripcomponents.size()==0) {
			tripcomponents.add(aComponent);
		}
		else {
			System.out.println("\nadding next");
			boolean added=false;
			boolean conflict=false;
			for(int index = 0 ; index<tripcomponents.size()&& !added && !conflict;index++) {
				TripComponent current = tripcomponents.get(index);
				if(aComponent.overlapsWith(current)) {
					conflict=true;
				}
				else if(aComponent.isBefore(current)) {
					tripcomponents.add(index,aComponent);
					added=true;
					System.out.println("Flights");

				}
			}
			if(!added && !conflict) {
				tripcomponents.add(aComponent);
				
			}
			//tripcomponents.add(aComponent);
		}
	}
		/*if (flights.size() == 0) {
			flights.add(h);
			return;
		}
		
		for (int i = 0; i < flights.size(); i++) {
			if(h.isBefore(flights.get(0))) {
				flights.add(0, h);
				break;
			}
			if (flights.get(flights.size()-1).isBefore(h)) {
				flights.add(h); 
				break;
			}
			TripComponent thisFlight = flights.get(i);
			
			if (!(thisFlight.overlapsWith(h))) {
				if (!(h.overlapsWith(flights.get(i+1))));
					flights.add(i+1, h);
			}
		}*/
	

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        for (int i = 0; i < tripcomponents.size(); i++) {
        	   sb.append(i).append("\t");
               sb.append(tripcomponents.get(i).getStart()).append("\t");
               sb.append(tripcomponents.get(i).getEnd()).append("\n");
           }
        return sb.toString();
    }
}
