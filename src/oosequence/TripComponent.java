package oosequence;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class TripComponent {

	private Date start;
	private Date end;
	
	public TripComponent(Date startdate, Date enddate) {
		if (startdate == null || enddate == null) {
			start = startdate;
			end = enddate;
		} else if (startdate.equals(enddate)) {
			start = startdate;
			end = null;
		} else if (startdate.after(enddate)) {
			start = startdate;
			end = null;
		} else {
			start = startdate;
			end = enddate;
		}
	}
	

	public TripComponent(TripComponent c) {
		start = c.start;
		end = c.end;
	}

	public TripComponent() {
		// TODO Auto-generated constructor stub
		start = new Date();
		end = new Date(start.getTime() + (60 * 60 * 1000));
	}


	public long lengthInSeconds() {
		long seconds = 0;
		if (start != null && end != null) {
			long millis = end.getTime() - start.getTime();
			seconds = millis / 1000;
		}
		return seconds;
	}

	public Date getStart() {
		return start;
	}


	public Date getEnd() {
		return end;
	}


	public void setStart(Date startdate) {
		if (startdate != null && (end == null || startdate.before(end))) {
			start = startdate;
		}
	}


	public void setEnd(Date enddate) {
		if (enddate != null && (start == null || enddate.after(start))) {
			end = enddate;
		}
	}
}