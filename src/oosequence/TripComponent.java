package oosequence;

import java.util.Date;

public class TripComponent{
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
        if (c.start != null) {
            start = new Date(c.start.getTime());
        } else {
            start = null;
        }
        
        if (c.end != null) {
            end = new Date(c.end.getTime());
        } else {
            end = null;
        }
    }

    public TripComponent() {
        start = new Date();
        end = new Date(start.getTime());
    }

    public long lengthInSeconds() {
        if (start == null || end == null) {
            return 0;
        }
        long millis = end.getTime() - start.getTime();
        return millis / 1000;
    }

    public String getStart() {
        if (start != null) {
            return start.toString();
        } else {
            return "";
        }     
    }

    public String getEnd() {
        if (end != null) {
            return end.toString();
        } else {
            return "";
        }
    }

    public void setStart(Date startdate) {
    	if (startdate == null) {
    		return;
    	}
    	if (end != null && startdate.after(end)) {
    		return;
    	}
    	start = new Date(startdate.getTime());
    }

    public void setEnd(Date enddate) {
        if (enddate == null) {
            return;
        }
        if (start != null && enddate.before(start)) {
            return;
        }
        end = new Date(enddate.getTime()); 
    }

    public boolean overlapsWith(TripComponent other) {
        if (other == null || start == null || end == null || other.start == null || other.end == null) {
            return false;
        } else {
            return !(start.after(other.end) || end.before(other.start));
        }
    }

	public boolean isBefore(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void add(TripComponent h) {
		// TODO Auto-generated method stub
		
	}
}
