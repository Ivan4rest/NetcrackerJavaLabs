package ParserCsv;

import Exceptions.ReflectionException;
import Reflection.Injector;
import com.Contracts.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class ParserCsvTest {

    Repository repository1;
    Repository repository2;
    Calendar startDate1;
    Calendar startDate2;
    Calendar startDate3;
    Calendar startDate4;
    Calendar startDate5;
    Calendar endDate1;
    Calendar endDate2;
    Calendar endDate3;
    Calendar endDate4;
    Calendar endDate5;
    Calendar birthDate1;
    Calendar birthDate2;
    Calendar birthDate3;
    Calendar birthDate4;
    Calendar birthDate5;
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    Person person5;
    MobilePhoneContract contract1;
    MobilePhoneContract contract2;
    WiredInternetContract contract3;
    WiredInternetContract contract4;
    String[] channelPackage = new String[]{"HBO", "FOX", "abc", "NBC", "CNN"};
    DigitalTVContract contract5;

    @BeforeEach
    void setUp() {
        repository1 = new Repository();
        repository2 = new Repository();
        startDate1 = new GregorianCalendar(2007, 5 , 16);
        startDate2 = new GregorianCalendar(2002, 8 , 19);
        startDate3 = new GregorianCalendar(1997, 0 , 28);
        startDate4 = new GregorianCalendar(2007, 2 , 11);
        startDate5 = new GregorianCalendar(1996, 11 , 24);
        endDate1 = new GregorianCalendar(2012, 8 , 23);
        endDate2 = new GregorianCalendar(2013, 0 , 27);
        endDate3 = new GregorianCalendar(2003, 1 , 11);
        endDate4 = new GregorianCalendar(2015, 3 , 24);
        endDate5 = new GregorianCalendar(2014, 5 , 2);
        birthDate1 = new GregorianCalendar(1998, 1 , 12);
        birthDate2 = new GregorianCalendar(1973, 2 , 31);
        birthDate3 = new GregorianCalendar(1982, 2 , 26);
        birthDate4 = new GregorianCalendar(1996, 11 , 24);
        birthDate5 = new GregorianCalendar(1974, 11 , 2);
        person1 = new Person(1, "Ильин Александр Артёмовичч", birthDate1, Gender.MALE, 385496273);
        person2 = new Person(2, "Соколов Роман Андреевич", birthDate2, Gender.MALE, 167078523);
        person3 = new Person(3, "Лазарева Дарья Матвеевна", birthDate3, Gender.FEMALE, 587429752);
        person4 = new Person(4, "Белов Максим Матвеевич", birthDate4, Gender.MALE, 688776303);
        person5 = new Person(5, "Калинина Кира Степановна", birthDate5, Gender.FEMALE, 862640764);
        contract1 = new MobilePhoneContract(1, startDate1, endDate1, 465390, person1, 829, 708, 946);
        contract2 = new MobilePhoneContract(2, startDate2, endDate2, 810100, person2, 561, 634, 704);
        contract3 = new WiredInternetContract(3, startDate3, endDate3, 527652, person3, 808);
        contract4 = new WiredInternetContract(4, startDate4, endDate4, 368860, person4, 725);
        contract5 = new DigitalTVContract(5, startDate5, endDate5, 188600, person5, channelPackage);
    }

    @Test
    void parseTest() throws IOException, ParseException, ReflectionException {
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5};
        repository1.add(contracts);
        ParserCsv parserCsv = new ParserCsv();
        parserCsv = Injector.inject(parserCsv);
        repository2 = ParserCsv.parse("src/main/resources/contracts.csv", repository2);
        assertEquals(repository1.getLength(), repository2.getLength());
        for(int i = 0; i < repository1.getLength(); i++){
            assertEquals(repository1.get()[i].getId(), repository2.get()[i].getId());
            assertEquals(repository1.get()[i].getNumber(), repository2.get()[i].getNumber());
            assertEquals(repository1.get()[i].getStartDate(), repository2.get()[i].getStartDate());
            assertEquals(repository1.get()[i].getEndDate(), repository2.get()[i].getEndDate());
        }
    }
}