import java.util.ArrayList;
import java.util.Calendar;

public class WiredInternetContract extends Contract{
    private int connectionSpeed;

    public WiredInternetContract(int id, Calendar startDate, Calendar endDate, int number, Person owner, int connectionSpeed){
        SetId(id);
        SetStartDate(startDate);
        SetEndDate(endDate);
        SetNumber(number);
        SetOwner(owner);
        SetConnectionSpeed(connectionSpeed);
    }

    /**
     * Setter for connectionSpeed
     * @param connectionSpeed
     */
    public void SetConnectionSpeed(int connectionSpeed){
        this.connectionSpeed = connectionSpeed;
    }

    /**
     * Getter for connectionSpeed
     * @return
     */
    public int GetConnectionSpeed(){
        return this.connectionSpeed;
    }

}
