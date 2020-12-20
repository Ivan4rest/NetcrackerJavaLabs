package Validators;

import com.Contracts.Contract;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ContractNumberValidator implements ContractValidator{
    private static Logger logger = Logger.getLogger(ContractNumberValidator.class);

    @Override
    public Message validate(Contract contract) {
        logger.info("Contract number validation started");
        List<Message> messages = new ArrayList<Message>();

        if(contract.getNumber() < 0){
            messages.add(new Message("Contract number less than 0", Status.ERROR));
        }

        return new Message(messages);
    }
}
