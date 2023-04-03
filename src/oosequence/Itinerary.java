package oosequence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;

public class Itinerary extends TripComponent{
	private ArrayList<TripComponent> Flight;
	private String name;

	public Itinerary(String name) {
		this.name = name;
		this.Flight = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
		

	public ArrayList<TripComponent> getTripComponents() {
		// TODO Auto-generated method stub
		return Flight;
		
	}

	public void addTripComponent(TripComponent h) {		
		if (TripComponent.size() == 0) {
			Flight.add(h);
			return;
		}
		
		for (int i = 0; i < Flight.size(); i++) {
			if(h.isBefore(Flight.get(0))) {
				Flight.add(h);
				return;
			}
			if (Flight.get(Flight.size() - 1).isBefore(h)) {
				Flight.add(h);
				return;
			}
			TripComponent thisFlight = Flight.get(i);
			
			if (!(thisFlight.overlapsWith(h))) {
				if (!(h.overlapsWith(Flight.get(i+1))))
					Flight.add(i+1, h);
			}
		}

	}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        for (int i = 0; i < Flight.size(); i++) {
        	   sb.append(i).append("\t");
               sb.append(Flight.get(i).getStart()).append("\t");
               sb.append(Flight.get(i).getEnd()).append("\n");
           }
        return sb.toString();
    }
}
