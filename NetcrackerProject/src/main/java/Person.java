import java.lang.String;
import java.util.Calendar;

public class Person {
    int id;
    String fio;
    Calendar birthDate;
    Gender gender;
    int passportSeriesAndNumber;

    public Person(int id, String fio, Calendar birthDate, Gender gender, int passportSeriesAndNumber){
        SetId(id);
        SetFio(fio);
        SetBirthDate(birthDate);
        SetGender(gender);
        SetPassportSeriesAndNumber(passportSeriesAndNumber);
    }

    /**
     * Setter for id
     * @param id
     */
    private void SetId(int id){
        this.id = id;
    }

    /**
     * Getter for id
     * @return
     */
    public int GetId(){
        return this.id;
    }

    /**
     * Setter for fio
     * @param fio
     */
    public void SetFio(String fio){
        this.fio = fio;
    }

    /**
     * Getter for fio
     * @return
     */
    public String GetFio(){
        return this.fio;
    }

    /**
     * Setter for birthDate
     * @param birthDate
     */
    public void SetBirthDate(Calendar birthDate){
        this.birthDate = birthDate;
    }

    /**
     * Getter for birthDate
     * @return
     */
    public Calendar GetBirthDate(){
        return this.birthDate;
    }

    /**
     * Setter for gender
     * @param gender
     */
    public void SetGender(Gender gender){
        this.gender = gender;
    }

    /**
     * Getter for gender
     * @return
     */
    public Gender GetGender(){
        return this.gender;
    }

    /**
     * Setter for passportSeriesAndNumber
     * @param passportSeriesAndNumber
     */
    public void SetPassportSeriesAndNumber(int passportSeriesAndNumber){
        this.passportSeriesAndNumber = passportSeriesAndNumber;
    }

    /**
     * Getter for passportSeriesAndNumber
     * @return
     */
    public int GetPassportSeriesAndNumber(){
        return this.passportSeriesAndNumber;
    }

    /**
     * Get the age of a person
     * @return
     */
    public int GetAge(){
        Calendar rightNow = Calendar.getInstance();
        if (rightNow.get(Calendar.DAY_OF_YEAR) >= GetBirthDate().get(Calendar.DAY_OF_YEAR)){
            return rightNow.get(Calendar.YEAR) - GetBirthDate().get(Calendar.YEAR);
        }
        else{
            return rightNow.get(Calendar.YEAR) - GetBirthDate().get(Calendar.YEAR) - 1;
        }
    }
}
