package Sorters;

import com.Contracts.Contract;

import java.util.Comparator;

public class BubbleSorter implements ISorter {
    public void sort(Contract[] contracts, Comparator comparator){
        for(int i = 0; i < contracts.length; i++){
            for(int j = 0; j < (contracts.length - i - 1); j++){
                if(comparator.compare(contracts[j], contracts[j + 1]) > 0){
                    Contract contract = contracts[j];
                    contracts[j] = contracts[j + 1];
                    contracts[j + 1] = contract;
                }
            }
        }
    }
}
