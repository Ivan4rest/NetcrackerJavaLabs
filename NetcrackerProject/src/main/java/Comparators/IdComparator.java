package Comparators;

import com.Contracts.Contract;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class IdComparator implements Comparator<Contract>{

    private static Logger logger = Logger.getLogger(IdComparator.class);

    @Override
    public int compare(Contract contract1, Contract contract2) {
        logger.info("Compare by id started");

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
