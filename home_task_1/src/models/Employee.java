package models;

import java.util.Date;
import java.util.UUID;

public class Employee {

    private UUID id;
    private String name;
    private Date dateOfBirthDay;
    private Rate rate;

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }


}
