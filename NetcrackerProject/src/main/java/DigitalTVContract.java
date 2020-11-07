import java.lang.String;
import java.util.ArrayList;
import java.util.Calendar;

public class DigitalTVContract extends Contract{

    private ArrayList<String> channelPackage = new ArrayList<String>();

    public static ArrayList<DigitalTVContract> contracts = new ArrayList<DigitalTVContract>();

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

    /**
     * Add contract
     * @param contract
     */
    public static void AddContract(DigitalTVContract contract){
        contracts.add(contract);
    }

    /**
     * Get contract by id
     * @param id
     * @return
     */
    public static DigitalTVContract GetContractById(int id){
        int index = 0;
        for(int i = 0; i < contracts.size(); i++){
            if(contracts.get(i).GetId() == id){
                index = i;
            }
        }
        return contracts.get(index);
    }

    /**
     * Delete contract by id
     * @param id
     */
    public static void DeleteContractById(int id){
        for(int i = 0; i < contracts.size(); i++){
            if(contracts.get(i).GetId() == id){
                contracts.remove(i);
                break;
            }
        }
    }
}