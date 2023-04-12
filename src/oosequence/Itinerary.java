package oosequence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;

public class Itinerary {
	private ArrayList<TripComponent> tripcomponents = new ArrayList<TripComponent>();
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
			return;
		}
		else {
			for(int index = 0 ; index<tripcomponents.size(); index++) {
			TripComponent current = tripcomponents.get(index);
			if(aComponent.overlapsWith(current)) {
			return;

			}
			else if(aComponent.isBefore(current)) {
			tripcomponents.add(index,aComponent);
			return;
			}
			}
			}
		
			tripcomponents.add(aComponent);
	}
	

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n");
        for (int i = 0; i < this.tripcomponents.size(); i++) {
        	   sb.append(i).append("\t");
               sb.append(tripcomponents.get(i).getStart()).append("\t");
               sb.append(tripcomponents.get(i).getEnd()).append("\n");
           }
        return sb.toString();
    }
 
}
