package oosequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Itinerary {
	private ArrayList<Flight> flights;
	private String name;

	public Itinerary(String string) {
		name = string;
		flights = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addFlight(Flight m) {
		flights.add(m);
	    
	    Collections.sort(flights, new Comparator<Flight>() {
	        public int compare(Flight f1, Flight f2) {
	            return f1.getDeparture().compareTo(f2.getDeparture());
	        }
	    });
	    
	    int i = 0;
	    while (i < flights.size() - 1) {
	        Flight currentFlight = flights.get(i);
	        Flight nextFlight = flights.get(i + 1);
	        if (currentFlight.getArrival().after(nextFlight.getDeparture())) {
	            flights.remove(i + 1);
	        } else {
	            i++;
	        }
	    }	
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public long getTotalLayover() {
		long getTotalLayover = 0;
        
        for (int i = 0; i < flights.size() - 1; i++) {
            Flight waitTime = flights.get(i);
            Flight nextFlight = flights.get(i + 1);
            long layover = nextFlight.getDeparture().getTime() - waitTime.getArrival().getTime();
            getTotalLayover += layover / (60 * 1000); 
        }
        return getTotalLayover;
    }
}
