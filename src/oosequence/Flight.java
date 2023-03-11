package oosequence;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class Flight {

	private Date departure;
	private Date arrival;

	public Flight(Date departuredate, Date arrivaldate) {
		if (departuredate == null && arrivaldate == null) {
			departure = departuredate;
			arrival = arrivaldate;
		} else if (departuredate.before(arrivaldate)) {
			departure = departuredate;
			arrival = arrivaldate;
		} else {
			departure = null;
			arrival = null;
		}
	}
	

	public Flight(Flight c) {
		departure = c.departure;
	    arrival = c.arrival;
	}

	public long length() {
		long Minutes = 0;
		if (departure != null && arrival != null) {
	    	long Millis = arrival.getTime() - departure.getTime();
	    	Minutes = Millis / (60 * 1000);
	    }
        return Minutes;
	}


	public Date getDeparture() {
		return departure;
	}


	public Date getArrival() {
		return arrival;
	}


	public void setDeparture(Date date) {
		if (date != null && arrival != null && date.before(arrival)) {
		departure = date;
		}
	}


	public void setArrival(Date date) {
		if (date != null && departure != null && date.after(departure)) {
		arrival = date;
		}
	}

}