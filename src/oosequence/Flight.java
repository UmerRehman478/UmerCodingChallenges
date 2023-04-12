package oosequence;

import java.util.Date;

public class Flight extends TripComponent {

	private String departureAirport;
	private String arrivalAirport;
	//public Date start;
	//public Date end;


	public Flight(Flight copy) {

		super(copy);
		departureAirport = copy.departureAirport;
		arrivalAirport = copy.arrivalAirport;

	}
	
	private boolean validAirport(String airportCode) {
		if (airportCode == null) {return false;}
		if (airportCode.length() != 3) {return false;}
		for (int i = 0; i<3; i++) {
			if (!Character.isAlphabetic(airportCode.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	public Flight(Date departureTime, Date arrivalTime, String departAirport, String arriveAirport) {
			super(departureTime,arrivalTime);

			if(departAirport !=null && validAirport(departAirport)) {
				departureAirport = departAirport;
			}
			else { departureAirport = "";}

			if(arriveAirport !=null && validAirport(arriveAirport)) {
				arrivalAirport = arriveAirport;
			}
			else { arrivalAirport = "";}


	}
	
	/*public Flight(Date date, Date date2, String string, String string2) {
		// TODO Auto-generated constructor stub
		start = date;
		end = date2;
		setDepartureAirport(string);
        setArrivalAirport(string2);
	}*/

	/*public Flight(Flight c) {
		// TODO Auto-generated constructor stub
		start = c.start;
		end = c.end;
		setDepartureAirport(c.departureAirport);
        setArrivalAirport(c.arrivalAirport);
	}*/

	
	public String getDepartureAirport() {
	    if (departureAirport != null) {
	        return departureAirport;
	    } else {
	        return "";
	    }
	}
	
	public void setDepartureAirport(String departureAirport) {
		if (departureAirport != null && departureAirport.length() == 3) {
			this.departureAirport = departureAirport;
	    } else {
	    	this.departureAirport = "";
	    }
	}
	
	
	public String getArrivalAirport() {
	    if (arrivalAirport == null) {
	        return "";
	    } else {
	        return arrivalAirport;
	    }
	}
	
	public void setArrivalAirport(String arrivalAirport) {
		if (arrivalAirport != null && arrivalAirport.length() == 3) {
			this.arrivalAirport = arrivalAirport;
		} else {
			this.arrivalAirport = "";
		}	
	}
	
	/*
	public void setStart(Date start) {
		this.start = start;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public String getDuration() {
		// TODO: calculate and return duration between start and end
		if (start == null || end == null) {
			return "";
		}
		long milliseconds = end.getTime() - start.getTime();
		long minutes = milliseconds / (60 * 1000);
		return minutes + " minutes";
	}
	*/

	@Override
	public String getStart() {
		return getDepartureAirport() + " " + super.getStart();
	}
	
	@Override
	public String getEnd() {
		return getArrivalAirport() + " " + super.getEnd();
	}

}