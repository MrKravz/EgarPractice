package models;

import java.util.Date;

public class Total {
    private Employee employee;
    private int totalTurnoutTime;
    private int totalSickDaysTime;
    private int totalVacationTime;
    private int totalBusinessTripTime;
    private int totalOverTime;
    private int totalAbsenceTime;
    private float totalSalary;
    private Date date;

    public Total() {
    }

    public int getTotalTurnoutTime() {
        return totalTurnoutTime;
    }

    public int getTotalSickDaysTime() {
        return totalSickDaysTime;
    }

    public int getTotalVacationTime() {
        return totalVacationTime;
    }

    public int getTotalBusinessTripTime() {
        return totalBusinessTripTime;
    }

    public int getTotalOverTime() {
        return totalOverTime;
    }

    public int getTotalAbsenceTime() {
        return totalAbsenceTime;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTotalTurnoutTime(int totalTurnoutTime) {
        this.totalTurnoutTime = totalTurnoutTime;
    }

    public void setTotalSickDaysTime(int totalSickDaysTime) {
        this.totalSickDaysTime = totalSickDaysTime;
    }

    public void setTotalVacationTime(int totalVacationTime) {
        this.totalVacationTime = totalVacationTime;
    }

    public void setTotalBusinessTripTime(int totalBusinessTripTime) {
        this.totalBusinessTripTime = totalBusinessTripTime;
    }

    public void setTotalOverTime(int totalOverTime) {
        this.totalOverTime = totalOverTime;
    }

    public void setTotalAbsenceTime(int totalAbsenceTime) {
        this.totalAbsenceTime = totalAbsenceTime;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
