import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    Repository repository;
    Calendar date1;
    Calendar date2;
    Person person1;
    MobilePhoneContract contract1;
    MobilePhoneContract contract2;
    WiredInternetContract contract3;
    WiredInternetContract contract4;
    ArrayList<String> channelPackage;
    DigitalTVContract contract5;
    DigitalTVContract contract6;

    @BeforeEach
    public void setUp() {
        repository = new Repository();
        date1 = new GregorianCalendar(1999, 0 , 25);
        date2 = new GregorianCalendar(2001, 0 , 25);
        person1 = new Person(1, "Иванов Иван Иванович", date1, Gender.MALE, 123);
        contract1 = new MobilePhoneContract(1, date1, date2, 12334, person1, 5, 5, 5);
        contract2 = new MobilePhoneContract(2, date1, date2, 12334, person1, 5, 5, 5);
        contract3 = new WiredInternetContract(3, date1, date2, 12334, person1, 5);
        contract4 = new WiredInternetContract(4, date1, date2, 12334, person1, 5);
        channelPackage = new ArrayList<String>();
        channelPackage.add("HBO");
        channelPackage.add("FOX");
        contract5 = new DigitalTVContract(5, date1, date2, 12334, person1, channelPackage);
        contract6 = new DigitalTVContract(6, date1, date2, 12334, person1, channelPackage);
    }

    @Test
    public void AddOneContractTest() {
        repository.Add(contract1);
        repository.Add(contract2);
        repository.Add(contract3);
        repository.Add(contract4);
        repository.Add(contract5);
        repository.Add(contract6);
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        for(int i = 0; i < repository.GetLength(); i++){
            assertEquals(repository.Get()[i], contracts[i]);
        }
    }

    @Test
    public void AddArrayOfContractsTest() {
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        repository.Add(contracts);
        for(int i = 0; i < repository.GetLength(); i++){
            assertEquals(repository.Get()[i], contracts[i]);
        }
    }

    @Test
    public void GetByIdTest() {
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        repository.Add(contracts);
        assertEquals(repository.GetById(1).GetId(), 1);
    }

    @Test
    public void DeleteByIdTest() {
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        repository.Add(contracts);
        repository.DeleteById(3);
        Contract[] contracts2 = new Contract[]{contract1, contract2, contract4, contract5, contract6};
        for(int i = 0; i < repository.GetLength(); i++){
            assertEquals(repository.Get()[i], contracts2[i]);
        }
    }
}