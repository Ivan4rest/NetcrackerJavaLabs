package Comparators;

import com.Contracts.Contract;

import java.util.Comparator;

public class EndDateComparator implements Comparator<Contract> {
    @Override
    public int compare(Contract contract1, Contract contract2) {
        return contract1.getEndDate().compareTo(contract2.getEndDate());
    }
}
