import com.Contracts.Gender;
import com.Contracts.Person;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testGetAge() {
        Calendar date = new GregorianCalendar(1999, 0 , 25);
        Calendar rightNow = Calendar.getInstance();
        Person person1 = new Person(1, "Иванов Иван Иванович", date, Gender.MALE, 123);

        int expected = person1.getAge();

        int actual;
        if (rightNow.get(Calendar.DAY_OF_YEAR) >= person1.getBirthDate().get(Calendar.DAY_OF_YEAR)){
            actual = rightNow.get(Calendar.YEAR) - person1.getBirthDate().get(Calendar.YEAR);
        }
        else{
            actual = rightNow.get(Calendar.YEAR) - person1.getBirthDate().get(Calendar.YEAR) - 1;
        }

        assertEquals(expected, actual);
    }
}