import java.lang.String;
import java.util.ArrayList;
import java.util.Calendar;

public class DigitalTVContract extends Contract{

    private ArrayList<String> channelPackage = new ArrayList<String>();

    public DigitalTVContract(int id, Calendar startDate, Calendar endDate, int number, Person owner, ArrayList<String> channelPackage){
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
    public void setChannelPackage(ArrayList<String> channelPackage){
        this.channelPackage = channelPackage;
    }

    /**
     * Getter for channelPackage
     * @return
     */
    public ArrayList<String> getChannelPackage(){
        return this.channelPackage;
    }

}