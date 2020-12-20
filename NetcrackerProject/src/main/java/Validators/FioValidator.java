package Validators;

import com.Contracts.Person;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FioValidator implements PersonValidator{
    private static Logger logger = Logger.getLogger(FioValidator.class);

    @Override
    public Message validate(Person person) {
        logger.info("Fio validation started");
        List<Message> messages = new ArrayList<Message>();

        if(person.getFio().split(" ").length != 3){
            messages.add(new Message("Fio does not consist of three words!", Status.ERROR));
        }

        return new Message(messages);
    }
}
