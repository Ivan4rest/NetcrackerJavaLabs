package com.Contracts;

import org.apache.log4j.Logger;

import java.lang.String;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Person {

    private static Logger logger = Logger.getLogger(Person.class);

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

    public Person(int id, String fio, Date birthDate, String gender, int passportSeriesAndNumber){
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
     * Setter for birthDate
     * @param birthDate
     */
    public void setBirthDate(Date birthDate){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(birthDate);
        this.birthDate = calendar;
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
     * Setter for gender
     * @param gender
     */
    public void setGender(String gender){
        if (gender == "MALE"){
            this.gender = Gender.MALE;
        }
        if (gender == "FEMALE"){
            this.gender = Gender.FEMALE;
        }
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

    public void saveToDB(Connection cn) throws SQLException {
        logger.info("Started adding person to db");
        PreparedStatement preparedStatement = cn.prepareStatement("insert into persons (id, fio, birth_date, gender, passport_series_and_number) values (?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, this.getId());
        preparedStatement.setString(2, this.getFio());
        preparedStatement.setDate(3, new java.sql.Date(this.getBirthDate().getTimeInMillis()));
        preparedStatement.setString(4, this.getGender().toString());
        preparedStatement.setInt(5, this.getPassportSeriesAndNumber());
        preparedStatement.executeUpdate();
        logger.info("Ended adding person to db");
    }

    public static Person getFromDBById(Connection cn, int personId) throws SQLException {
        logger.info("Started getting person from db");
        PreparedStatement preparedStatement = cn.prepareStatement("select * from persons where id = ?");
        preparedStatement.setInt(1, personId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Person person = null;
        while (resultSet.next()){
            person = new Person(resultSet.getInt("id"), resultSet.getString("fio"), resultSet.getDate("birth_date"), resultSet.getString("gender"), resultSet.getInt("passport_series_and_number"));
        }
        logger.info("Ended getting person from db");
        return person;
    }
}
