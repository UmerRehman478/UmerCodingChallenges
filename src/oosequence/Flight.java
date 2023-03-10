package oosequence;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class Flight {

	private Date departure;
	private Date arrival;

	public Flight(Date departuredate, Date arrivaldate2) {
		if (departuredate == null && arrivaldate2 == null) {
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
		// TODO Auto-generated method stub
		return departure;
	}


	public Date getArrival() {
		// TODO Auto-generated method stub
		return arrival;
	}


	public void setDeparture(Date date) {
		// TODO Auto-generated method stub
		departure = date;
	}


	public void setArrival(Date date) {
		// TODO Auto-generated method stub
		arrival = date;
	}

}