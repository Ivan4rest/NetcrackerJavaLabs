import java.lang.String;
import java.util.ArrayList;
import java.util.Calendar;

public class DigitalTVContract extends Contract{

    private ArrayList<String> channelPackage = new ArrayList<String>();

    public DigitalTVContract(int id, Calendar startDate, Calendar endDate, int number, Person owner, ArrayList<String> channelPackage){
        SetId(id);
        SetStartDate(startDate);
        SetEndDate(endDate);
        SetNumber(number);
        SetOwner(owner);
        SetChannelPackage(channelPackage);
    }

    /**
     * Setter for channelPackage
     * @param channelPackage
     */
    public void SetChannelPackage(ArrayList<String> channelPackage){
        this.channelPackage = channelPackage;
    }

    /**
     * Getter for channelPackage
     * @return
     */
    public ArrayList<String> GetChannelPackage(){
        return this.channelPackage;
    }

}