import java.util.Calendar;

public abstract class Contract {
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
    public void SetId(int id){
        this.id = id;
    }

    /**
     * Getter for id
     * @return
     */
    public int GetId(){
        return this.id;
    }

    /**
     * Setter for startDate
     * @param startDate
     */
    public void SetStartDate(Calendar startDate){
        this.startDate = startDate;
    }

    /**
     * Getter for startDate
     * @return
     */
    public Calendar GetStartDate(){
        return this.startDate;
    }

    /**
     * Setter for endDate
     * @param endDate
     */
    public void SetEndDate(Calendar endDate){
        this.endDate = endDate;
    }

    /**
     * Getter for endDate
     * @return
     */
    public Calendar GetEndDate(){
        return this.endDate;
    }

    /**
     * Setter for number
     * @param number
     */
    public void SetNumber(int number){
        this.number = number;
    }

    /**
     * Getter for number
     * @return
     */
    public int GetNumber(){
        return this.number;
    }

    /**
     * Setter for owner
     * @param owner
     */
    public void SetOwner(Person owner){
        this.owner = owner;
    }

    /**
     * Getter for owner
     * @return
     */
    public Person GetOwner(){
        return this.owner;
    }
}
