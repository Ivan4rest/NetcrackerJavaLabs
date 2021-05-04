import ScriptRunner.ScriptRunner;
import com.Contracts.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDBCTest {

    Repository repository1;
    Repository repository2;
    Calendar date1;
    Calendar date2;
    Calendar date3;
    Calendar date4;
    Calendar date5;
    Calendar date6;
    Person person1;
    MobilePhoneContract contract1;
    MobilePhoneContract contract2;
    WiredInternetContract contract3;
    WiredInternetContract contract4;
    String[] channelPackage = new String[]{"HBO", "FOX", "abc", "NBC", "CNN"};
    DigitalTVContract contract5;
    DigitalTVContract contract6;

    private static Connection cn;

    @BeforeEach
    void createConnection() {
        repository1 = new Repository();
        date1 = new GregorianCalendar(1999, 0 , 10);
        date2 = new GregorianCalendar(2001, 6 , 25);
        date3 = new GregorianCalendar(1997, 2 , 15);
        date4 = new GregorianCalendar(1999, 7 , 3);
        date5 = new GregorianCalendar(1996, 0 , 23);
        date6 = new GregorianCalendar(2002, 4 , 5);
        person1 = new Person(1, "Иванов Иван Иванович", date1, Gender.MALE, 123);
        contract1 = new MobilePhoneContract(1, date5, date6, 12334, person1, 5, 5, 5);
        contract2 = new MobilePhoneContract(2, date1, date2, 12334, person1, 5, 5, 5);
        contract3 = new WiredInternetContract(3, date3, date4, 12334, person1, 5);
        contract4 = new WiredInternetContract(4, date5, date4, 12334, person1, 5);
        contract5 = new DigitalTVContract(5, date1, date4, 12334, person1, channelPackage);
        contract6 = new DigitalTVContract(6, date1, date2, 12334, person1, channelPackage);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try{
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Contracts", "postgres", "admin");
            ScriptRunner sr = new ScriptRunner(cn);
            sr.setLogWriter(null);
            sr.runScript(new InputStreamReader(cn.getClass().getClassLoader().getResourceAsStream("create_tables.sql")));
        }
        catch (SQLException e){
            cn = null;
        }
    }

    @Test
    void addToDBAndGetFromDBTest(){
        try {
            Contract[] contracts = new Contract[]{contract5, contract6, contract1, contract2, contract3, contract4};
            repository1.add(contracts);
            person1.saveToDB(cn);
            repository1.saveToDB(cn);
            repository2 = new Repository();
            repository2.getFromDB(cn);
            for (int i = 0; i < repository1.getLength(); i++) {
                assertEquals(repository1.get()[i].getId(), repository2.get()[i].getId());
            }
        }
        catch (SQLException e){
            cn = null;
        }
    }

    @AfterEach
    void afterAll() throws SQLException {
        cn.close();
    }
}
