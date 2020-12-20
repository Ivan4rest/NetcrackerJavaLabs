package Validators;

import com.Contracts.Contract;
import com.Contracts.MobilePhoneContract;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class NumberOfMinutesValidator implements ContractValidator{
    private static Logger logger = Logger.getLogger(NumberOfMinutesValidator.class);

    @Override
    public Message validate(Contract contract) {
        logger.info("Number of minutes validation started");
        if(contract.getClass().equals(MobilePhoneContract.class)){
            List<Message> messages = new ArrayList<Message>();

            if(((MobilePhoneContract) contract).getNumberOfMinutes() < 0){
                messages.add(new Message("Number of minutes less than 0", Status.ERROR));
            }

            return new Message(messages);

        }
        else{
            return null;
        }
    }
}
