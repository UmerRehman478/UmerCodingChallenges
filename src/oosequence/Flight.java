package oosequence;

import java.util.Date;

public class Flight {

	private String departureAirport;
	private String arrivalAirport;
	private Date start;
	private Date end;
	
	public String getDepartureAirport() {
		return departureAirport;
	}
	
	public void setDepartureAirport(String departureAirport) {
		if (departureAirport != null && departureAirport.length() == 3) {
			this.departureAirport = departureAirport;
	    } else {
	    	this.departureAirport = "";
	    }
	}
	
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	
	public void setArrivalAirport(String arrivalAirport) {
		if (arrivalAirport != null && arrivalAirport.length() == 3) {
			this.arrivalAirport = arrivalAirport;
		} else {
			this.arrivalAirport = "";
		}	
	}
	
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

}