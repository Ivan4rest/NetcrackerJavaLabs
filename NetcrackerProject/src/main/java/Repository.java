public class Repository {
    /**
     * Array containing contracts
     */
    private Contract[] contracts;

    /**
     * The last index of array
     */
    private int lastIndex = -1;

    /**
     * Constructor, setting array's length 0
     */
    public Repository(){
        contracts = new Contract[0];
    }

    /**
     * Get all contracts
     * @return
     */
    public Contract[] get(){
        if(getLength() > (lastIndex + 1)){
            Contract[] returnedArray = new Contract[lastIndex + 1];
            for(int i = 0; i < returnedArray.length; i++){
                returnedArray[i] = contracts[i];
            }
            return returnedArray;
        }
        else{
            return this.contracts;
        }
    }

    /**
     * Get contract by id
     * @param id
     * @return
     */
    public Contract getById(int id){
        for(int i = 0; i < getLength(); i++){
            if(contracts[i].getId() == id){
                return contracts[i];
            }
        }
        return null;
    }

    /**
     * Get length of array
     * @return
     */
    public int getLength(){
        return contracts.length;
    }

    /**
     * Delete contract by id
     * @param id
     */
    public void deleteById(int id){
        Contract[] truncatedArray = new Contract[getLength() - 1];
        for(int i = 0; i <= lastIndex; i++){
            if(i == lastIndex){
                if(contracts[i].getId() == id){
                    lastIndex--;
                    contracts = truncatedArray;
                    break;
                }
            }
            else{
                truncatedArray[i] = contracts[i];
                if(contracts[i].getId() == id){
                    for(int j = i; j < lastIndex; j++){
                        truncatedArray[j] = contracts[j + 1];
                    }
                    lastIndex--;
                    contracts = truncatedArray;
                    break;
                }
            }

        }
    }

    /**
     * Add one contract to array
     * @param contract
     */
    public void add(Contract contract){
        if((getLength() - 1) > lastIndex){
            contracts[++lastIndex] = contract;
        }
        else{
            Contract[] extendedArray = new Contract[getLength() + 1];
            for(int i = 0; i < getLength(); i++){
                extendedArray[i] = contracts[i];
            }
            extendedArray[++lastIndex] = contract;
            contracts = extendedArray;
        }
    }

    /**
     * Add array of contracts to array
     * @param contracts
     */
    public void add(Contract[] contracts){
        if((getLength() - (lastIndex + 1)) > contracts.length){
            for(int i = 0; i < contracts.length; i++){
                this.contracts[++lastIndex] = contracts[i];
            }
        }
        else{
            Contract[] extendedArray = new Contract[getLength() + contracts.length];
            for(int i = 0; i < getLength(); i++){
                extendedArray[i] = this.contracts[i];
            }
            for(int i = 0; i < contracts.length; i++){
                extendedArray[++lastIndex] = contracts[i];
            }
            this.contracts = extendedArray;
        }
    }
}
