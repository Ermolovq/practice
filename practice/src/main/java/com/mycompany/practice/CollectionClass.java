package com.mycompany.practice;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Клас, який може містити в собі числа та результати дій над ними в текстовому форматі.
 */
public class CollectionClass implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private ArrayList <Integer> numbers;
    private ArrayList <Integer> results;
    private int min;
    private int max;
    private double avg;
    private int i = 0;

    public CollectionClass() {
        this.numbers = new ArrayList<>();
        this.results = new ArrayList<>(); 
        this.min = 0;
        this.max = 0;
        this.avg = 0;
    }
    
    public int getNumber(int c) {
        return numbers.get(c);
    }
    public int getResult(int c) {
        return results.get(c);
    }
    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }
    public double getAvg() {
        return avg;
    }
    public int getSize() {
        return i;
    }
    
    public void setMin(int min) {
        this.min = min;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    
    public void add(int num, int result) {
        this.numbers.add(num);
        this.results.add(result);
        i++;
    }
}
