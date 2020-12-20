package Validators;

import com.Contracts.Contract;

public interface ContractValidator {
    public Message validate(Contract contract);
}
