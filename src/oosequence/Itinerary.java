package oosequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Itinerary {
	private ArrayList<Flight> flightList;
	private String name;

	public Itinerary(String string) {
		name = string;
		flightList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addFlight(Flight m) {
		flightList.add(m);
	    
	    Collections.sort(flightList, new Comparator<Flight>() {
	        public int compare(Flight f1, Flight f2) {
	            return f1.getDeparture().compareTo(f2.getDeparture());
	        }
	    });
	    
	    int i = 0;
	    while (i < flightList.size() - 1) {
	        Flight currentFlight = flightList.get(i);
	        Flight nextFlight = flightList.get(i + 1);
	        if (currentFlight.getArrival().after(nextFlight.getDeparture())) {
	        	flightList.remove(i + 1);
	        } else {
	            i++;
	        }
	    }	
	}

	public ArrayList<Flight> getFlights() {
		return flightList;
	}

	public long getTotalLayover() {
		long getTotalLayover = 0;
        
        for (int i = 0; i < flightList.size() - 1; i++) {
            Flight waitTime = flightList.get(i);
            Flight nextFlight = flightList.get(i + 1);
            long layover = nextFlight.getDeparture().getTime() - waitTime.getArrival().getTime();
            getTotalLayover += layover / (60 * 1000); 
        }
        return getTotalLayover;
    }

	public ArrayList<Flight> getFlightList() {
		// TODO Auto-generated method stub
		return new ArrayList<>(flightList);
	}
}
