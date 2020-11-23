package Comparators;

import com.Contracts.Contract;

import java.util.Comparator;

public class StartDateComparator implements Comparator<Contract> {
    @Override
    public int compare(Contract contract1, Contract contract2) {
        return contract1.getStartDate().compareTo(contract2.getStartDate());
    }
}
