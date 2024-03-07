package com.mycompany.practice;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Клас, який може містити в собі результати дій в текстовому форматі.
 */
public class CollectionClass implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private ArrayList<String> results;
    private int i = 0;

    public CollectionClass() {
        this.results = new ArrayList<>();
    }

    public String getResult(int c){
        return results.get(c);
    }
    public int getSize() {
        return results.size();
    }
    
    public void addResult (String result) {
        this.results.add(result);
        i++;
    }
}
