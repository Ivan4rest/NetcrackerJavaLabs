package Comparators;

import com.Contracts.Contract;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class StartDateComparator implements Comparator<Contract> {

    private static Logger logger = Logger.getLogger(StartDateComparator.class);

    @Override
    public int compare(Contract contract1, Contract contract2) {
        logger.info("Compare by startdate started");

        return contract1.getStartDate().compareTo(contract2.getStartDate());
    }
}
