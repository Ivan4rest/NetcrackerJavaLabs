package Comparators;

import com.Contracts.Contract;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class EndDateComparator implements Comparator<Contract> {

    private static Logger logger = Logger.getLogger(EndDateComparator.class);

    @Override
    public int compare(Contract contract1, Contract contract2) {
        logger.info("Compare by enddate started");

        return contract1.getEndDate().compareTo(contract2.getEndDate());
    }
}
