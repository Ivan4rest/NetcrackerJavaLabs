package Comparators;

import com.Contracts.Contract;

import java.util.Comparator;

public class IdComparator implements Comparator<Contract>{
    @Override
    public int compare(Contract contract1, Contract contract2) {
        if(contract1.getId() > contract2.getId()){
            return 1;
        }
        else if(contract1.getId() < contract2.getId()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
