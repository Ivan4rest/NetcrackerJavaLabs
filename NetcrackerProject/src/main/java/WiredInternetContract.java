import java.util.ArrayList;
import java.util.Calendar;

public class WiredInternetContract extends Contract{
    private int connectionSpeed;
    public static ArrayList<WiredInternetContract> contracts = new ArrayList<WiredInternetContract>();

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

    /**
     * Add contract
     * @param contract
     */
    public static void AddContract(WiredInternetContract contract){
        contracts.add(contract);
    }

    /**
     * Get contract by id
     * @param id
     * @return
     */
    public static WiredInternetContract GetContractById(int id){
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
