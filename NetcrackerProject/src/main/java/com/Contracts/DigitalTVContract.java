package com.Contracts;

import java.lang.String;
import java.sql.Date;
import java.util.Calendar;

public class DigitalTVContract extends Contract{

    private String[] channelPackages;

    public DigitalTVContract(int id, Calendar startDate, Calendar endDate, int number, Person owner, String[] channelPackages){
        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setNumber(number);
        setOwner(owner);
        setChannelPackages(channelPackages);
    }

    public DigitalTVContract(int id, Date startDate, Date endDate, int number, Person owner, String[] channelPackages){
        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setNumber(number);
        setOwner(owner);
        setChannelPackages(channelPackages);
    }

    /**
     * Setter for channelPackages
     * @param channelPackages
     */
    public void setChannelPackages(String[] channelPackages){
        this.channelPackages = channelPackages;
    }

    /**
     * Getter for channelPackages
     * @return
     */
    public String[] getChannelPackages(){
        return this.channelPackages;
    }

    /**
     * Getter for channelPackages
     * @return
     */
    public String getChannelPackages(String separatingCharacter){
        String channelPackages = "";
        for (int i = 0; i < this.channelPackages.length; i++) {
            channelPackages += separatingCharacter + this.channelPackages[i];
        }
        return channelPackages;
    }

}