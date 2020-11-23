package Sorters;

import com.Contracts.Contract;

import java.util.Comparator;

public class SelectionSorter implements ISorter {
    public void sort(Contract[] contracts, Comparator comparator){
        for(int i = 0; i < contracts.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < contracts.length; j++){
                if(comparator.compare(contracts[min], contracts[j]) > 0){
                    min = j;
                }
            }
            Contract contract = contracts[i];
            contracts[i] = contracts[min];
            contracts[min] = contract;
        }
    }
}
