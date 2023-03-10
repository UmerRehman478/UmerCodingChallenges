package oosequence;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class Flight {

	Date departure;
	Date arrival;

	Flight(Date departuredate, Date arrivaldate2) {
		if (departuredate == null || arrivaldate2 == null) {
			departure = departuredate;
			arrival = arrivaldate2;
		} else if (departuredate.before(arrivaldate2)) {
			departure = departuredate;
			arrival = arrivaldate2;
		} else {
			departure = null;
			arrival = null;
		}
	}
	

	Flight(Flight c) {
		departure = c.departure;
	    arrival = c.arrival;
	}

	Object length() {
		long Minutes = 0;
		if (departure != null && arrival != null) {
	    	long Millis = arrival.getTime() - departure.getTime();
	    	Minutes = Millis / (60 * 1000);
	    }
        return Minutes;
	}

}