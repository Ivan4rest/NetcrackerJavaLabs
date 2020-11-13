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
     * Constructor, setting array's length by default
     */
    public Repository(){
        contracts = new Contract[0];
    }

    /**
     * Get all contracts
     * @return
     */
    public Contract[] Get(){
        if(GetLength() > (lastIndex + 1)){
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
    public Contract GetById(int id){
        for(int i = 0; i < GetLength(); i++){
            if(contracts[i].GetId() == id){
                return contracts[i];
            }
        }
        return null;
    }

    /**
     * Get length of array
     * @return
     */
    public int GetLength(){
        return contracts.length;
    }

    /**
     * Delete contract by id
     * @param id
     */
    public void DeleteById(int id){
        Contract[] truncatedArray = new Contract[GetLength() - 1];
        for(int i = 0; i <= lastIndex; i++){
            if(i == lastIndex){
                if(contracts[i].GetId() == id){
                    lastIndex--;
                    contracts = truncatedArray;
                    break;
                }
            }
            else{
                truncatedArray[i] = contracts[i];
                if(contracts[i].GetId() == id){
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
    public void Add(Contract contract){
        if((GetLength() - 1) > lastIndex){
            contracts[++lastIndex] = contract;
        }
        else{
            Contract[] extendedArray = new Contract[GetLength() + 1];
            for(int i = 0; i < GetLength(); i++){
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
    public void Add(Contract[] contracts){
        if((GetLength() - (lastIndex + 1)) > contracts.length){
            for(int i = 0; i < contracts.length; i++){
                this.contracts[++lastIndex] = contracts[i];
            }
        }
        else{
            Contract[] extendedArray = new Contract[GetLength() + contracts.length];
            for(int i = 0; i < GetLength(); i++){
                extendedArray[i] = this.contracts[i];
            }
            for(int i = 0; i < contracts.length; i++){
                extendedArray[++lastIndex] = contracts[i];
            }
            this.contracts = extendedArray;
        }
    }
}
