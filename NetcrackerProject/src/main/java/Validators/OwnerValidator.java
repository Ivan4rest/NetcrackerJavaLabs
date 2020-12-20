package Validators;

import com.Contracts.Contract;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OwnerValidator implements ContractValidator{
    private static Logger logger = Logger.getLogger(OwnerValidator.class);

    @Override
    public Message validate(Contract contract) {
        logger.info("Owner validation started");
        List<PersonValidator> validators = new ArrayList<PersonValidator>();
        List<Message> messages = new ArrayList<Message>();
        FioValidator fioValidator = new FioValidator();
        PassportSeriesAndNumberValidator passportSeriesAndNumberValidator = new PassportSeriesAndNumberValidator();
        validators.add(fioValidator);
        validators.add(passportSeriesAndNumberValidator);

        for (int i = 0; i < validators.size(); i++) {
            messages.add(validators.get(i).validate(contract.getOwner()));
        }

        return new Message(messages);
    }
}
