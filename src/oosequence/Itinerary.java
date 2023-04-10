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
			boolean added=false;
			boolean conflict=false;
			//System.out.println("size" + tripcomponents.size());
			for(int index = 0 ; index<tripcomponents.size(); index++) {
				TripComponent current = tripcomponents.get(index);
				if(aComponent.overlapsWith(current)) {
					conflict=true;
					return;
				}
				else if(aComponent.isBefore(current)) {
					tripcomponents.add(index,aComponent);
					added=true;
					return;
				}
			}
			if(!added) {
				tripcomponents.add(aComponent);
			}
		}
	}
	

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
