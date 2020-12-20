package Comparators;

import com.Contracts.Contract;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class NumberComparator implements Comparator<Contract> {

    private static Logger logger = Logger.getLogger(NumberComparator.class);

    @Override
    public int compare(Contract contract1, Contract contract2) {
        logger.info("Compare by number started");

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
