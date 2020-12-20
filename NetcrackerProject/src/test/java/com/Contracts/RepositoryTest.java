package com.Contracts;

import Comparators.EndDateComparator;
import Comparators.IdComparator;
import Comparators.StartDateComparator;
import Sorters.BubbleSorter;
import Sorters.SelectionSorter;
import com.Contracts.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class  RepositoryTest {
    Repository repository;
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
    IdComparator idComparator;
    StartDateComparator startDateComparator;
    EndDateComparator endDateComparator;
    BubbleSorter bubbleSorter;
    SelectionSorter selectionSorter;

    @BeforeEach
    public void setUp() {
        repository = new Repository();
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
        idComparator = new IdComparator();
        startDateComparator = new StartDateComparator();
        endDateComparator = new EndDateComparator();
        bubbleSorter = new BubbleSorter();
        selectionSorter = new SelectionSorter();
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

    @Test
    public void searchByTest() {
        Contract[] contracts = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        Contract[] contracts2 = new Contract[]{contract4, contract5, contract6};
        repository.add(contracts);
        Predicate<Contract> condition = new Predicate<Contract>() {
            @Override
            public boolean test(Contract contract) {
                return contract.getId() > 3;
            }
        };
        repository = repository.searchBy(condition);
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts2[i]);
        }
    }

    @Test
    public void BubbleSortByIdTest() {
        Contract[] contracts = new Contract[]{contract4, contract5, contract6, contract1, contract2, contract3};
        Contract[] contracts2 = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        repository.add(contracts);
        repository.sortBy(idComparator, bubbleSorter);
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts2[i]);
        }
    }

    @Test
    public void BubbleSortByStartDateTest() {
        Contract[] contracts = new Contract[]{contract3, contract2, contract1};
        Contract[] contracts2 = new Contract[]{contract1, contract3, contract2};
        repository.add(contracts);
        repository.sortBy(startDateComparator, bubbleSorter);
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts2[i]);
        }
    }

    @Test
    public void BubbleSortByEndDateTest() {
        Contract[] contracts = new Contract[]{contract1, contract3, contract2};
        Contract[] contracts2 = new Contract[]{contract3, contract2, contract1};
        repository.add(contracts);
        repository.sortBy(endDateComparator, bubbleSorter);
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts2[i]);
        }
    }

    @Test
    public void SelectionSortByIdTest() {
        Contract[] contracts = new Contract[]{contract4, contract5, contract6, contract1, contract2, contract3};
        Contract[] contracts2 = new Contract[]{contract1, contract2, contract3, contract4, contract5, contract6};
        repository.add(contracts);
        repository.sortBy(idComparator, selectionSorter);
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts2[i]);
        }
    }

    @Test
    public void SelectionSortByStartDateTest() {
        Contract[] contracts = new Contract[]{contract3, contract2, contract1};
        Contract[] contracts2 = new Contract[]{contract1, contract3, contract2};
        repository.add(contracts);
        repository.sortBy(startDateComparator, selectionSorter);
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts2[i]);
        }
    }

    @Test
    public void SelectionSortByEndDateTest() {
        Contract[] contracts = new Contract[]{contract1, contract3, contract2};
        Contract[] contracts2 = new Contract[]{contract3, contract2, contract1};
        repository.add(contracts);
        repository.sortBy(endDateComparator, selectionSorter);
        for(int i = 0; i < repository.getLength(); i++){
            assertEquals(repository.get()[i], contracts2[i]);
        }
    }
}