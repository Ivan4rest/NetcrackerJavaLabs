import java.util.Calendar;

public class WiredInternetContract extends Contract{
    private int connectionSpeed;

    public WiredInternetContract(int id, Calendar startDate, Calendar endDate, int number, Person owner, int connectionSpeed){
        setId(id);
        setStartDate(startDate);
        setEndDate(endDate);
        setNumber(number);
        setOwner(owner);
        setConnectionSpeed(connectionSpeed);
    }

    /**
     * Setter for connectionSpeed
     * @param connectionSpeed
     */
    public void setConnectionSpeed(int connectionSpeed){
        this.connectionSpeed = connectionSpeed;
    }

    /**
     * Getter for connectionSpeed
     * @return
     */
    public int getConnectionSpeed(){
        return this.connectionSpeed;
    }

}
