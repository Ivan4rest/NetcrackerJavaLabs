package com.Contracts;

import Reflection.AutoInjectable;
import Sorters.ISorter;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.function.Predicate;

@XmlRootElement(name = "repository")
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {
    private static Logger logger = Logger.getLogger(Repository.class);

    @AutoInjectable
    @XmlTransient
    ISorter sorter;

    /**
     * Array containing contracts
     */
    @XmlElement(name = "contract")
    @XmlElementWrapper
    private Contract[] contracts;

    /**
     * The last index of array
     */
    @XmlAttribute
    private int lastIndex = -1;

    /**
     * Constructor, setting array's length 0
     */
    public Repository(){
        logger.info("Created new repository");
        contracts = new Contract[0];
    }

    /**
     * Get all contracts
     * @return
     */
    public Contract[] get(){
        if(getLength() > (lastIndex + 1)){
            Contract[] returnedArray = new Contract[lastIndex + 1];
            for(int i = 0; i < returnedArray.length; i++){
                returnedArray[i] = contracts[i];
            }
            return returnedArray;
        }
        else{
            return this.contracts;
        }
    }

    /**
     * Get contract by id
     * @param id
     * @return
     */
    public Contract getById(int id){
        for(int i = 0; i < getLength(); i++){
            if(contracts[i].getId() == id){
                return contracts[i];
            }
        }
        return null;
    }

    /**
     * Get length of array
     * @return
     */
    public int getLength(){
        return contracts.length;
    }

    /**
     * Delete contract by id
     * @param id
     */
    public void deleteById(int id){
        logger.info("Contract deleted by id from repository");
        Contract[] truncatedArray = new Contract[getLength() - 1];
        for(int i = 0; i <= lastIndex; i++){
            if(i == lastIndex){
                if(contracts[i].getId() == id){
                    lastIndex--;
                    contracts = truncatedArray;
                    break;
                }
            }
            else{
                truncatedArray[i] = contracts[i];
                if(contracts[i].getId() == id){
                    for(int j = i; j < lastIndex; j++){
                        truncatedArray[j] = contracts[j + 1];
                    }
                    lastIndex--;
                    contracts = truncatedArray;
                    break;
                }
            }

        }
    }

    /**
     * Add one contract to array
     * @param contract
     */
    public void add(Contract contract){
        logger.info("Added new contract to repository");
        if(contract != null){
            if((getLength() - 1) > lastIndex){
                contracts[++lastIndex] = contract;
            }
            else{
                Contract[] extendedArray = new Contract[getLength() + 1];
                for(int i = 0; i < getLength(); i++){
                    extendedArray[i] = contracts[i];
                }
                extendedArray[++lastIndex] = contract;
                contracts = extendedArray;
            }
        }
    }

    /**
     * Add array of contracts to array
     * @param contracts
     */
    public void add(Contract[] contracts){
        logger.info("Added new contracts to repository");
        if((getLength() - (lastIndex + 1)) > contracts.length){
            for(int i = 0; i < contracts.length; i++){
                if(contracts[i] != null){
                    this.contracts[++lastIndex] = contracts[i];
                }
            }
        }
        else{
            Contract[] extendedArray = new Contract[getLength() + contracts.length];
            for(int i = 0; i < getLength(); i++){
                extendedArray[i] = this.contracts[i];
            }
            for(int i = 0; i < contracts.length; i++){
                if(contracts[i] != null) {
                    extendedArray[++lastIndex] = contracts[i];
                }
            }
            this.contracts = extendedArray;
        }
    }

    /**
     * Array search with a condition
     * @param condition
     * @return
     */
    public Repository searchBy(Predicate<Contract> condition){
        Repository repository = new Repository();
        for(int i = 0; i < contracts.length; i++){
            if(condition.test(get()[i])){
                repository.add(get()[i]);
            }
        }
        return repository;
    }

    /**
     * Ascending sort
     * @param comparator
     */
    public void sortBy(Comparator<Contract> comparator){
        sorter.sort(contracts, comparator);
    }

    public void saveToDB(Connection cn) throws SQLException {
        logger.info("Started adding contracts to db");
        PreparedStatement preparedStatement;
        for (int i = 0; i < get().length; i++) {
            if(get()[i].getClass() == DigitalTVContract.class){
                DigitalTVContract digitalTVContract = (DigitalTVContract) get()[i];
                preparedStatement = cn.prepareStatement("insert into digital_tv_contracts (id, start_date, end_date, contract_number, owner_id, channel_packages) values (?, ?, ?, ?, ?, ?)");
                preparedStatement.setInt(1, digitalTVContract.getId());
                preparedStatement.setDate(2, new java.sql.Date(digitalTVContract.getStartDate().getTimeInMillis()));
                preparedStatement.setDate(3, new java.sql.Date(digitalTVContract.getEndDate().getTimeInMillis()));
                preparedStatement.setInt(4, digitalTVContract.getNumber());
                preparedStatement.setInt(5, digitalTVContract.getOwner().getId());
                preparedStatement.setString(6, digitalTVContract.getChannelPackages(";"));
                preparedStatement.executeUpdate();
                logger.info("Add digitalTVContract to db");
            }
            else if(get()[i].getClass() == MobilePhoneContract.class){
                MobilePhoneContract mobilePhoneContract = (MobilePhoneContract) get()[i];
                preparedStatement = cn.prepareStatement("insert into mobile_phone_contracts (id, start_date, end_date, contract_number, owner_id, number_of_minutes, number_of_sms, amount_of_traffic) values (?, ?, ?, ?, ?, ?, ?, ?)");
                preparedStatement.setInt(1, mobilePhoneContract.getId());
                preparedStatement.setDate(2, new java.sql.Date(mobilePhoneContract.getStartDate().getTimeInMillis()));
                preparedStatement.setDate(3, new java.sql.Date(mobilePhoneContract.getEndDate().getTimeInMillis()));
                preparedStatement.setInt(4, mobilePhoneContract.getNumber());
                preparedStatement.setInt(5, mobilePhoneContract.getOwner().getId());
                preparedStatement.setInt(6, mobilePhoneContract.getNumberOfMinutes());
                preparedStatement.setInt(7, mobilePhoneContract.getNumberOfSMS());
                preparedStatement.setInt(8, mobilePhoneContract.getAmountOfTraffic());
                preparedStatement.executeUpdate();
                logger.info("Add mobilePhoneContract to db");
            }
            else if (get()[i].getClass() == WiredInternetContract.class){
                WiredInternetContract wiredInternetContract = (WiredInternetContract) get()[i];
                preparedStatement = cn.prepareStatement("insert into wired_internet_contracts (id, start_date, end_date, contract_number, owner_id, connection_speed) values(?, ?, ?, ?, ?, ?)");
                preparedStatement.setInt(1, wiredInternetContract.getId());
                preparedStatement.setDate(2, new java.sql.Date(wiredInternetContract.getStartDate().getTimeInMillis()));
                preparedStatement.setDate(3, new java.sql.Date(wiredInternetContract.getEndDate().getTimeInMillis()));
                preparedStatement.setInt(4, wiredInternetContract.getNumber());
                preparedStatement.setInt(5, wiredInternetContract.getOwner().getId());
                preparedStatement.setInt(6, wiredInternetContract.getConnectionSpeed());
                preparedStatement.executeUpdate();
                logger.info("Add wiredInternetContract to db");
            }
        }
        logger.info("Ended adding contracts to db");
    }

    public void getFromDB(Connection cn) throws SQLException {
        logger.info("Started getting contracts from db");
        PreparedStatement preparedStatementDigitalTVContract = cn.prepareStatement("select * from digital_tv_contracts");
        ResultSet resultSet = preparedStatementDigitalTVContract.executeQuery();
        while (resultSet.next()){
            Person person = Person.getFromDBById(cn, resultSet.getInt("owner_id"));
            DigitalTVContract digitalTVContract = new DigitalTVContract(resultSet.getInt("id"), resultSet.getDate("start_date"), resultSet.getDate("end_date"), resultSet.getInt("contract_number"), person, resultSet.getString("channel_packages").split(";"));
            add(digitalTVContract);
            logger.info("Get digitalTVContract from db");
        }

        PreparedStatement preparedStatementMobilePhoneContract = cn.prepareStatement("select * from mobile_phone_contracts");
        resultSet = preparedStatementMobilePhoneContract.executeQuery();
        while (resultSet.next()){
            Person person = Person.getFromDBById(cn, resultSet.getInt("owner_id"));
            MobilePhoneContract mobilePhoneContract = new MobilePhoneContract(resultSet.getInt("id"), resultSet.getDate("start_date"), resultSet.getDate("end_date"), resultSet.getInt("contract_number"), person, resultSet.getInt("number_of_minutes"), resultSet.getInt("number_of_sms"), resultSet.getInt("amount_of_traffic"));
            add(mobilePhoneContract);
            logger.info("Get mobilePhoneContract from db");
        }

        PreparedStatement preparedStatementWiredInternetContract = cn.prepareStatement("select * from wired_internet_contracts");
        resultSet = preparedStatementWiredInternetContract.executeQuery();
        while (resultSet.next()){
            Person person = Person.getFromDBById(cn, resultSet.getInt("owner_id"));
            WiredInternetContract wiredInternetContract = new WiredInternetContract(resultSet.getInt("id"), resultSet.getDate("start_date"), resultSet.getDate("end_date"), resultSet.getInt("contract_number"), person, resultSet.getInt("connection_speed"));
            add(wiredInternetContract);
            logger.info("Get wiredInternetContract from db");
        }

        logger.info("Ended getting contracts from db");
    }
}
