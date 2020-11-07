import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class WiredInternetContractTest {
    Calendar date1;
    Calendar date2;
    Person person1;
    WiredInternetContract contract1;
    WiredInternetContract contract2;
    WiredInternetContract contract3;

    @BeforeEach
    void setUp() {
        date1 = new GregorianCalendar(1999, 0 , 25);
        date2 = new GregorianCalendar(2001, 0 , 25);
        person1 = new Person(1, "Иванов Иван Иванович", date1, Gender.MALE, 123);
        contract1 = new WiredInternetContract(1, date1, date2, 12334, person1, 5);
        contract2 = new WiredInternetContract(2, date1, date2, 12334, person1, 5);
        contract3 = new WiredInternetContract(3, date1, date2, 12334, person1, 5);
    }

    @Test
    public void AddContractTest() {
        WiredInternetContract.AddContract(contract1);
        WiredInternetContract.AddContract(contract2);
        WiredInternetContract.AddContract(contract3);
        ArrayList<WiredInternetContract> contracts = new ArrayList<WiredInternetContract>();
        contracts.add(contract1);
        contracts.add(contract2);
        contracts.add(contract3);

        assertEquals(WiredInternetContract.contracts, contracts);

    }

    @Test
    public void GetContractByIdTest() {
        WiredInternetContract.AddContract(contract1);
        WiredInternetContract.AddContract(contract2);
        WiredInternetContract.AddContract(contract3);
        WiredInternetContract contract = new WiredInternetContract(1, date1, date2, 12334, person1, 5);
        assertEquals(WiredInternetContract.GetContractById(1).GetId(), contract.GetId());
    }

    @Test
    public void DeleteContractByIdTest() {
        WiredInternetContract.AddContract(contract1);
        WiredInternetContract.AddContract(contract2);
        WiredInternetContract.AddContract(contract3);
        WiredInternetContract.DeleteContractById(1);
        ArrayList<WiredInternetContract> contracts = new ArrayList<WiredInternetContract>();
        contracts.add(contract2);
        contracts.add(contract3);

        assertEquals(WiredInternetContract.contracts, contracts);
    }
}