package com.Contracts;

import java.lang.String;
import java.util.Calendar;
import java.util.Objects;

public class Person {
    int id;
    String fio;
    Calendar birthDate;
    Gender gender;
    int passportSeriesAndNumber;

    public Person(int id, String fio, Calendar birthDate, Gender gender, int passportSeriesAndNumber){
        setId(id);
        setFio(fio);
        setBirthDate(birthDate);
        setGender(gender);
        setPassportSeriesAndNumber(passportSeriesAndNumber);
    }

    /**
     * Setter for id
     * @param id
     */
    private void setId(int id){
        this.id = id;
    }

    /**
     * Getter for id
     * @return
     */
    public int getId(){
        return this.id;
    }

    /**
     * Setter for fio
     * @param fio
     */
    public void setFio(String fio){
        this.fio = fio;
    }

    /**
     * Getter for fio
     * @return
     */
    public String getFio(){
        return this.fio;
    }

    /**
     * Setter for birthDate
     * @param birthDate
     */
    public void setBirthDate(Calendar birthDate){
        this.birthDate = birthDate;
    }

    /**
     * Getter for birthDate
     * @return
     */
    public Calendar getBirthDate(){
        return this.birthDate;
    }

    /**
     * Setter for gender
     * @param gender
     */
    public void setGender(Gender gender){
        this.gender = gender;
    }

    /**
     * Getter for gender
     * @return
     */
    public Gender getGender(){
        return this.gender;
    }

    /**
     * Setter for passportSeriesAndNumber
     * @param passportSeriesAndNumber
     */
    public void setPassportSeriesAndNumber(int passportSeriesAndNumber){
        this.passportSeriesAndNumber = passportSeriesAndNumber;
    }

    /**
     * Getter for passportSeriesAndNumber
     * @return
     */
    public int getPassportSeriesAndNumber(){
        return this.passportSeriesAndNumber;
    }

    /**
     * Get the age of a person
     * @return
     */
    public int getAge(){
        Calendar rightNow = Calendar.getInstance();
        if (rightNow.get(Calendar.DAY_OF_YEAR) >= getBirthDate().get(Calendar.DAY_OF_YEAR)){
            return rightNow.get(Calendar.YEAR) - getBirthDate().get(Calendar.YEAR);
        }
        else{
            return rightNow.get(Calendar.YEAR) - getBirthDate().get(Calendar.YEAR) - 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                passportSeriesAndNumber == person.passportSeriesAndNumber &&
                Objects.equals(fio, person.fio) &&
                Objects.equals(birthDate, person.birthDate) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, birthDate, gender, passportSeriesAndNumber);
    }
}
