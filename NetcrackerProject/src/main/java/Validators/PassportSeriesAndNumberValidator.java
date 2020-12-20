package Validators;

import com.Contracts.Person;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PassportSeriesAndNumberValidator implements PersonValidator{
    private static Logger logger = Logger.getLogger(PassportSeriesAndNumberValidator.class);

    @Override
    public Message validate(Person person) {
        logger.info("Passport series and number validation started");
        List<Message> messages = new ArrayList<Message>();

        if(person.getPassportSeriesAndNumber() < 0){
            messages.add(new Message("Passport series and number less than 0", Status.ERROR));
        }

        return new Message(messages);
    }
}
