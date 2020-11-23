package Sorters;

import com.Contracts.Contract;

import java.util.Comparator;

public interface ISorter {
    public void sort(Contract[] contracts, Comparator comparator);
}
