package Validators;

import com.Contracts.Contract;
import com.Contracts.MobilePhoneContract;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AmountOfTrafficValidator implements ContractValidator{
    private static Logger logger = Logger.getLogger(AmountOfTrafficValidator.class);

    @Override
    public Message validate(Contract contract) {
        logger.info("Amount of traffic validation started");
        if(contract.getClass().equals(MobilePhoneContract.class)){
            List<Message> messages = new ArrayList<Message>();

            if(((MobilePhoneContract) contract).getAmountOfTraffic() < 0){
                messages.add(new Message("Amount of traffic less than 0", Status.ERROR));
            }

            return new Message(messages);

        }
        else{
            return null;
        }
    }
}
