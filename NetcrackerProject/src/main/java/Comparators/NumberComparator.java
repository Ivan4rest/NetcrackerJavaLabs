package Comparators;

import com.Contracts.Contract;

import java.util.Comparator;

public class NumberComparator implements Comparator<Contract> {
    @Override
    public int compare(Contract contract1, Contract contract2) {
        if(contract1.getNumber() > contract2.getNumber()){
            return 1;
        }
        else if(contract1.getNumber() < contract2.getNumber()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
