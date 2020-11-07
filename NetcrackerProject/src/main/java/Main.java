import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args){
        Calendar date1 = new GregorianCalendar(1999, 0 , 25);
        Calendar date2 = new GregorianCalendar(2001, 0 , 25);
        Person person1 = new Person(1, "Иванов Иван Иванович", date1, Gender.MALE, 123);
        MobilePhoneContract contract1 = new MobilePhoneContract(1, date1, date2, 12334, person1, 5, 5, 5);
        MobilePhoneContract contract2 = new MobilePhoneContract(2, date1, date2, 12334, person1, 5, 5, 5);
        MobilePhoneContract contract3 = new MobilePhoneContract(3, date1, date2, 12334, person1, 5, 5, 5);

        MobilePhoneContract.AddContract(contract1);
        MobilePhoneContract.AddContract(contract2);
        MobilePhoneContract.AddContract(contract3);
        MobilePhoneContract contract = new MobilePhoneContract(1, date1, date2, 12334, person1, 5, 5, 5);
        System.out.println(MobilePhoneContract.contracts.get(0).GetId());
        System.out.println(MobilePhoneContract.GetContractById(2).GetId());
    }
}
