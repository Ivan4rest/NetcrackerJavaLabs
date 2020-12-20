package Validators;

import com.Contracts.Contract;
import com.Contracts.WiredInternetContract;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionSpeedValidator implements ContractValidator{
    private static Logger logger = Logger.getLogger(ConnectionSpeedValidator.class);

    @Override
    public Message validate(Contract contract) {
        logger.info("Connection speed validation started");
        if(contract.getClass().equals(WiredInternetContract.class)){
            List<Message> messages = new ArrayList<Message>();

            if(((WiredInternetContract) contract).getConnectionSpeed() < 0){
                messages.add(new Message("Connection speed less than 0", Status.ERROR));
            }

            return new Message(messages);

        }
        else{
            return null;
        }
    }
}
