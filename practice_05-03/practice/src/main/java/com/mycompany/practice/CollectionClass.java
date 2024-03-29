package com.mycompany.practice;

import java.io.Serializable;
import java.util.ArrayList;

class CollectionClass implements Serializable {
    /**
     * Клас, який може містити в собі результати різних дій в текстовому форматі.
     */
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
    
    public void addResult (String number) {
        this.results.add(number);
        i++;
    }
}
