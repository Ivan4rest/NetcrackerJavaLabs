package ParserCsv;

import com.Contracts.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParserCsv {
    private static final int CONTRACT_ID_INDEX = 0;
    private static final int START_DATE_INDEX = 1;
    private static final int END_DATE_INDEX = 2;
    private static final int NUMBER_INDEX = 3;
    private static final int PERSON_INDEX = 4;
    private static final int TYPE_CONTRACT_INDEX = 5;
    private static final int CONNECTION_SPEED_INDEX = 6;
    private static final int CHANNEL_PACKAGE_INDEX = 6;
    private static final int NUMBER_OF_MINUTES_INDEX = 6;
    private static final int NUMBER_OF_SMS_INDEX = 7;
    private static final int AMOUNT_OF_TRAFFIC_INDEX = 8;

    private static final int PERSON_ID_INDEX = 0;
    private static final int FIO_INDEX = 1;
    private static final int BIRTH_DATE_INDEX = 2;
    private static final int GENDER_INDEX = 3;
    private static final int PASSPORT_SERIES_AND_NUMBER_INDEX = 4;

    static List<Person> persons = new ArrayList<>();

    /**
     *Reading from a file line by line
     * @param fileName
     * @return
     * @throws IOException
     */
    private static List<String> read(final String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    /**
     *Converting the list of strings to the repository
     * @param fileName
     * @param repository
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static Repository parse(final String fileName, Repository repository) throws IOException, ParseException {
        List<String> lines = read(fileName);
        for(int i = 0; i < lines.size(); i++){
            String[] subStrContract = lines.get(i).split(";");
            String[] subStrPerson = subStrContract[PERSON_INDEX].split(",");
            Contract contract;
            Calendar birthDate = new GregorianCalendar();
            Calendar startDate = new GregorianCalendar();
            Calendar endDate = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            birthDate.setTime(sdf.parse(subStrPerson[BIRTH_DATE_INDEX]));
            startDate.setTime(sdf.parse(subStrContract[START_DATE_INDEX]));
            endDate.setTime(sdf.parse(subStrContract[END_DATE_INDEX]));
            Gender gender;
            if(subStrPerson[GENDER_INDEX] == "MALE"){
                gender = Gender.MALE;
            }
            else if(subStrPerson[GENDER_INDEX] == "FEMALE"){
                gender = Gender.FEMALE;
            }
            else{
                gender = null;
            }
            Person person = null;
            for(int j = 0; j < persons.size(); j++){
                if(persons.get(j).equals(new Person(Integer.parseInt(subStrPerson[PERSON_ID_INDEX]), subStrPerson[FIO_INDEX],
                        birthDate, gender, Integer.parseInt(subStrPerson[PASSPORT_SERIES_AND_NUMBER_INDEX])))){
                    person = persons.get(j);
                }
            }
            if(person == null){
                person = new Person(Integer.parseInt(subStrPerson[PERSON_ID_INDEX]), subStrPerson[FIO_INDEX],
                        birthDate, gender, Integer.parseInt(subStrPerson[PASSPORT_SERIES_AND_NUMBER_INDEX]));
                persons.add(person);
            }
            switch(subStrContract[TYPE_CONTRACT_INDEX]){
                case "Mobile phone":
                    contract = new MobilePhoneContract(Integer.parseInt(subStrContract[CONTRACT_ID_INDEX]),
                                                        startDate, endDate,
                                                        Integer.parseInt(subStrContract[NUMBER_INDEX]),
                                                        person,
                                                        Integer.parseInt(subStrContract[NUMBER_OF_MINUTES_INDEX]),
                                                        Integer.parseInt(subStrContract[NUMBER_OF_SMS_INDEX]),
                                                        Integer.parseInt(subStrContract[AMOUNT_OF_TRAFFIC_INDEX]));
                    break;
                case "Wired internet":
                    contract = new WiredInternetContract(Integer.parseInt(subStrContract[CONTRACT_ID_INDEX]),
                                                            startDate, endDate,
                                                            Integer.parseInt(subStrContract[NUMBER_INDEX]),
                                                            person,
                                                            Integer.parseInt(subStrContract[CONNECTION_SPEED_INDEX]));
                    break;
                case "Digital TV":
                    String[] channelPackage = subStrContract[CHANNEL_PACKAGE_INDEX].split(",");
                    contract = new DigitalTVContract(Integer.parseInt(subStrContract[CONTRACT_ID_INDEX]),
                                                        startDate, endDate,
                                                        Integer.parseInt(subStrContract[NUMBER_INDEX]),
                                                        person,
                                                        channelPackage);
                    break;
                default:
                    contract = null;
                    break;
            }
            repository.add(contract);
        }
        return repository;
    }
}
