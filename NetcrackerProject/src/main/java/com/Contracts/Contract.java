package com.Contracts;

import JAXB.ContractXmlAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@XmlJavaTypeAdapter(ContractXmlAdapter.class)
public abstract class Contract{
    private int id;

    private Calendar startDate;

    private Calendar endDate;

    private int number;

    private Person owner;

    public Contract(){
    }

    /**
     * Setter for id
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Getter for id
     * @return
     */
    public int getId(){
        return this.id;
    }

    /**
     * Setter for startDate
     * @param startDate
     */
    public void setStartDate(Calendar startDate){
        this.startDate = startDate;
    }

    /**
     * Setter for startDate
     * @param startDate
     */
    public void setStartDate(Date startDate){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        this.startDate = calendar;
    }

    /**
     * Getter for startDate
     * @return
     */
    public Calendar getStartDate(){
        return this.startDate;
    }

    /**
     * Setter for endDate
     * @param endDate
     */
    public void setEndDate(Calendar endDate){
        this.endDate = endDate;
    }

    /**
     * Setter for endDate
     * @param endDate
     */
    public void setEndDate(Date endDate){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(endDate);
        this.endDate = calendar;
    }

    /**
     * Getter for endDate
     * @return
     */
    public Calendar getEndDate(){
        return this.endDate;
    }

    /**
     * Setter for number
     * @param number
     */
    public void setNumber(int number){
        this.number = number;
    }

    /**
     * Getter for number
     * @return
     */
    public int getNumber(){
        return this.number;
    }

    /**
     * Setter for owner
     * @param owner
     */
    public void setOwner(Person owner){
        this.owner = owner;
    }

    /**
     * Getter for owner
     * @return
     */
    public Person getOwner(){
        return this.owner;
    }
}
