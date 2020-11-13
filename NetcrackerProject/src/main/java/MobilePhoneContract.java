import java.util.ArrayList;
import java.util.Calendar;

public class MobilePhoneContract extends Contract{
    private int numberOfMinutes;
    private int numberOfSMS;
    private int amountOfTraffic;

    public MobilePhoneContract(int id, Calendar startDate, Calendar endDate, int number, Person owner,
                               int numberOfMinutes, int numberOfSMS, int amountOfTraffic){
        SetId(id);
        SetStartDate(startDate);
        SetEndDate(endDate);
        SetNumber(number);
        SetOwner(owner);
        SetNumberOfMinutes(numberOfMinutes);
        SetNumberOfSMS(numberOfSMS);
        SetAmountOfTraffic(amountOfTraffic);
    }

    /**
     * Setter for numberOfMinutes
     * @param numberOfMinutes
     */
    public void SetNumberOfMinutes(int numberOfMinutes){
        this.numberOfMinutes = numberOfMinutes;
    }

    /**
     * Getter for numberOfMinutes
     * @return
     */
    public int GetNumberOfMinutes(){
        return this.numberOfMinutes;
    }

    /**
     * Setter for numberOfSMS
     * @param numberOfSMS
     */
    public void SetNumberOfSMS(int numberOfSMS){
        this.numberOfSMS = numberOfSMS;
    }

    /**
     * Getter for numberOfSMS
     * @return
     */
    public int GetNumberOfSMS(){
        return this.numberOfSMS;
    }

    /**
     * Setter for amountOfTraffic
     * @param amountOfTraffic
     */
    public void SetAmountOfTraffic(int amountOfTraffic){
        this.amountOfTraffic = amountOfTraffic;
    }

    /**
     * Getter for amountOfTraffic
     * @return
     */
    public int GetAmountOfTraffic(){
        return this.amountOfTraffic;
    }

}