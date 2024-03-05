package com.mycompany.practice;

import java.io.Serializable;
import java.util.ArrayList;

class CollectionClass implements Serializable {
    /**
     * Клас який може містити в собі результати різних дій в рядковому форматі.
     */
    private static final long serialVersionUID = 1L;
    
    private ArrayList<String> results;
    private int i = 0;

    public CollectionClass() {
        this.results = new ArrayList<>();
    }

    public void getResults() {
        for(int c = 0; c < results.size(); c++){
            System.out.print(results.get(c) + " ");
        }
        System.out.println();
    }
    
    public void addResult (String number) {
        this.results.add(number);
        i++;
    }
    public void delResult (int number) {
        this.results.remove(number);
    }
}
