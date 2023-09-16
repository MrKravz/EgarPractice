package models;

import java.util.Date;

public class TimeSheet {

    private Employee employee;
    private int timeSpan;
    private TimeStatus timeStatus;
    private Date date;

    public int getTimeSpan() {
        return timeSpan;
    }

    public TimeStatus getTimeStatus() {
        return timeStatus;
    }
}
