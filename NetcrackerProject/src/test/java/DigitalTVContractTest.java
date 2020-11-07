import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class DigitalTVContractTest {
    Calendar date1;
    Calendar date2;
    Person person1;
    ArrayList<String> channelPackage = new ArrayList<String>();
    DigitalTVContract contract1;
    DigitalTVContract contract2;
    DigitalTVContract contract3;

    @BeforeEach
    void setUp() {
        date1 = new GregorianCalendar(1999, 0 , 25);
        date2 = new GregorianCalendar(2001, 0 , 25);
        person1 = new Person(1, "Иванов Иван Иванович", date1, Gender.MALE, 123);
        channelPackage.add("HBO");
        channelPackage.add("FOX");
        contract1 = new DigitalTVContract(1, date1, date2, 12334, person1, channelPackage);
        contract2 = new DigitalTVContract(2, date1, date2, 12334, person1, channelPackage);
        contract3 = new DigitalTVContract(3, date1, date2, 12334, person1, channelPackage);
    }

    @Test
    public void AddContractTest() {
        DigitalTVContract.AddContract(contract1);
        DigitalTVContract.AddContract(contract2);
        DigitalTVContract.AddContract(contract3);
        ArrayList<DigitalTVContract> contracts = new ArrayList<DigitalTVContract>();
        contracts.add(contract1);
        contracts.add(contract2);
        contracts.add(contract3);

        assertEquals(DigitalTVContract.contracts, contracts);

    }

    @Test
    public void GetContractByIdTest() {
        DigitalTVContract.AddContract(contract1);
        DigitalTVContract.AddContract(contract2);
        DigitalTVContract.AddContract(contract3);
        DigitalTVContract contract = new DigitalTVContract(1, date1, date2, 12334, person1, channelPackage);
        assertEquals(DigitalTVContract.GetContractById(1).GetId(), contract.GetId());
    }

    @Test
    public void DeleteContractByIdTest() {
        DigitalTVContract.AddContract(contract1);
        DigitalTVContract.AddContract(contract2);
        DigitalTVContract.AddContract(contract3);
        DigitalTVContract.DeleteContractById(1);
        ArrayList<DigitalTVContract> contracts = new ArrayList<DigitalTVContract>();
        contracts.add(contract2);
        contracts.add(contract3);

        assertEquals(DigitalTVContract.contracts, contracts);
    }
}