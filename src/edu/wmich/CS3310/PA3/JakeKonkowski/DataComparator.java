package edu.wmich.CS3310.PA3.JakeKonkowski;

import java.util.Comparator;

public class DataComparator<T> implements Comparator<T>{
	
    public int compare(T o1, T o2){
    	return ((Integer) o1).compareTo((Integer) o2);
    }
}
