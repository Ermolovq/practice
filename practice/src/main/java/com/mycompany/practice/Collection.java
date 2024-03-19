package com.mycompany.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Інтерйфейс, що реалізує FactoryMethod
 */
public interface Collection {
    void drawTable(CollectionClass list);
    void drawTable(CollectionClass list, String type);
}

class Table implements Collection {
    @Override
    public void drawTable(CollectionClass list){
        // Перевірка на null
        if(list.getSize() == 0){
            System.out.println("List with results is empty.");
            return;
        }
        
        System.out.println("ID\tNumber\tBinary Alternations");
        for(int i = 0; i < list.getSize(); i++){
            System.out.println(i + "\t" + list.getNumber(i) + "\t" + list.getResult(i));
        }
    }
    @Override
    public void drawTable(CollectionClass list, String type) {
        if(list.getSize() == 0){
            System.out.println("List with results is empty.");
            return;
        }
        
        ExecutorService math = Executors.newFixedThreadPool(3);
        
        Runnable min = new Math("min", list);
        Runnable max = new Math("max", list);
        Runnable avg = new Math("avg", list);
        
        switch(type){
            // Таблиця з індексами до результатів
            case "default" -> {
                System.out.println("ID\tNumber\tBinary Alternations");
                for(int i = 0; i < list.getSize(); i++) {
                    System.out.println(i + "\t" + list.getNumber(i) + "\t" + list.getResult(i));
                }
                Command.doMath(math, min, max, avg);
                System.out.println("\nMin = " + list.getMin() + "\t\tMax = " + list.getMax() + "\t\tAverage = " + list.getAvg());
            }
            // Така ж таблиця, але з виділенням
            case "border" -> {
                System.out.println("-----------------------------------");
                System.out.println("ID\tNumber\tBinary Alternations");
                for(int i = 0; i < list.getSize(); i++){
                    System.out.println(i + "\t" + list.getNumber(i) + "\t" + list.getResult(i));
                }
                Command.doMath(math, min, max, avg);
                System.out.println("\nMin = " + list.getMin() + "\t\tMax = " + list.getMax() + "\t\tAverage = " + list.getAvg());
                System.out.println("-----------------------------------");
            }
        }
    }
}

interface Factory {
    Collection factoryMethod();
}

class TableFactory implements Factory {
    @Override
    public Collection factoryMethod() {
        return new Table();
    }
}