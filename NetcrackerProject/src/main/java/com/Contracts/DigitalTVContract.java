package com.Contracts;

import java.lang.String;
import java.util.Calendar;

public class DigitalTVContract extends Contract{

    private String[] channelPackage;

    public DigitalTVContract(int id, Calendar startDate, Calendar endDate, int number, Person owner, String[] channelPackage){
        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setNumber(number);
        setOwner(owner);
        setChannelPackage(channelPackage);
    }

    /**
     * Setter for channelPackage
     * @param channelPackage
     */
    public void setChannelPackage(String[] channelPackage){
        this.channelPackage = channelPackage;
    }

    /**
     * Getter for channelPackage
     * @return
     */
    public String[] getChannelPackage(){
        return this.channelPackage;
    }

}