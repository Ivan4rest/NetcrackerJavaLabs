package com.Contracts;

import java.sql.Date;
import java.util.Calendar;

public class MobilePhoneContract extends Contract{
    private int numberOfMinutes;
    private int numberOfSMS;
    private int amountOfTraffic;

    public MobilePhoneContract(int id, Calendar startDate, Calendar endDate, int number, Person owner,
                               int numberOfMinutes, int numberOfSMS, int amountOfTraffic){
        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setNumber(number);
        setOwner(owner);
        setNumberOfMinutes(numberOfMinutes);
        setNumberOfSMS(numberOfSMS);
        setAmountOfTraffic(amountOfTraffic);
    }

    public MobilePhoneContract(int id, Date startDate, Date endDate, int number, Person owner,
                               int numberOfMinutes, int numberOfSMS, int amountOfTraffic){
        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setNumber(number);
        setOwner(owner);
        setNumberOfMinutes(numberOfMinutes);
        setNumberOfSMS(numberOfSMS);
        setAmountOfTraffic(amountOfTraffic);
    }

    /**
     * Setter for numberOfMinutes
     * @param numberOfMinutes
     */
    public void setNumberOfMinutes(int numberOfMinutes){
        this.numberOfMinutes = numberOfMinutes;
    }

    /**
     * Getter for numberOfMinutes
     * @return
     */
    public int getNumberOfMinutes(){
        return this.numberOfMinutes;
    }

    /**
     * Setter for numberOfSMS
     * @param numberOfSMS
     */
    public void setNumberOfSMS(int numberOfSMS){
        this.numberOfSMS = numberOfSMS;
    }

    /**
     * Getter for numberOfSMS
     * @return
     */
    public int getNumberOfSMS(){
        return this.numberOfSMS;
    }

    /**
     * Setter for amountOfTraffic
     * @param amountOfTraffic
     */
    public void setAmountOfTraffic(int amountOfTraffic){
        this.amountOfTraffic = amountOfTraffic;
    }

    /**
     * Getter for amountOfTraffic
     * @return
     */
    public int getAmountOfTraffic(){
        return this.amountOfTraffic;
    }

}