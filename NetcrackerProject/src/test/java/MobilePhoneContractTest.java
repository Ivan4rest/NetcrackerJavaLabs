import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class MobilePhoneContractTest {

    Calendar date1;
    Calendar date2;
    Person person1;
    MobilePhoneContract contract1;
    MobilePhoneContract contract2;
    MobilePhoneContract contract3;

    @BeforeEach
    void setUp() {
        date1 = new GregorianCalendar(1999, 0 , 25);
        date2 = new GregorianCalendar(2001, 0 , 25);
        person1 = new Person(1, "Иванов Иван Иванович", date1, Gender.MALE, 123);
        contract1 = new MobilePhoneContract(1, date1, date2, 12334, person1, 5, 5, 5);
        contract2 = new MobilePhoneContract(2, date1, date2, 12334, person1, 5, 5, 5);
        contract3 = new MobilePhoneContract(3, date1, date2, 12334, person1, 5, 5, 5);
    }

    @Test
    public void AddContractTest() {
        MobilePhoneContract.AddContract(contract1);
        MobilePhoneContract.AddContract(contract2);
        MobilePhoneContract.AddContract(contract3);
        ArrayList<MobilePhoneContract> contracts = new ArrayList<MobilePhoneContract>();
        contracts.add(contract1);
        contracts.add(contract2);
        contracts.add(contract3);

        assertEquals(MobilePhoneContract.contracts, contracts);

    }

    @Test
    public void GetContractByIdTest() {
        MobilePhoneContract.AddContract(contract1);
        MobilePhoneContract.AddContract(contract2);
        MobilePhoneContract.AddContract(contract3);
        MobilePhoneContract contract = new MobilePhoneContract(1, date1, date2, 12334, person1, 5, 5, 5);
        assertEquals(MobilePhoneContract.GetContractById(1).GetId(), contract.GetId());
    }

    @Test
    public void DeleteContractByIdTest() {
        MobilePhoneContract.AddContract(contract1);
        MobilePhoneContract.AddContract(contract2);
        MobilePhoneContract.AddContract(contract3);
        MobilePhoneContract.DeleteContractById(1);
        ArrayList<MobilePhoneContract> contracts = new ArrayList<MobilePhoneContract>();
        contracts.add(contract2);
        contracts.add(contract3);

        assertEquals(MobilePhoneContract.contracts, contracts);
    }
}