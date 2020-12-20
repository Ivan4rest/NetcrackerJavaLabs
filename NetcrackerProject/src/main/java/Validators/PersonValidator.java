package Validators;

import com.Contracts.Person;

public interface PersonValidator {
    public Message validate(Person person);
}
