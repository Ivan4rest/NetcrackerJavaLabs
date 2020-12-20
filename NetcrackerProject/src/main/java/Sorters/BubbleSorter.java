package Sorters;

import com.Contracts.Contract;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class BubbleSorter implements ISorter {
    private static Logger logger = Logger.getLogger(BubbleSorter.class);

    public void sort(Contract[] contracts, Comparator comparator){
        logger.info("Bubble sort started");
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
