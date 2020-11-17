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
    public void addOneContractTest() {
        repository.add(contract1);
        repository.add(contract2);
        repository.add(contract3);
        repository.add(contract4);
        repository.add(contract5);
        repository.add(contract6);
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts[i]);
        }
    }

    @Test
    public void addArrayOfContractsTest() {
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        repository.add(contracts);
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts[i]);
        }
    }

    @Test
    public void getByIdTest() {
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        repository.add(contracts);
        assertEquals(repository.getById(1).getId(), 1);
    }

    @Test
    public void deleteByIdTest() {
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        repository.add(contracts);
        repository.deleteById(3);
        Contract[] contracts2 = new Contract[]{contract1, contract2, contract4, contract5, contract6};
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts2[i]);
        }
    }
}