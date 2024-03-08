package com.mycompany.practice;
/**
 * Клас, що реалізує паралельне виконання
 */
public class Math implements Runnable{
    private String task;
    private CollectionClass list;
    
    public Math(String task, CollectionClass list) {
        this.task = task;
        this.list = list;
    }
    
    @Override
    public void run() {
        switch(task){
            case "min": // Розраховуємо мінімум
                list.setMin(list.getResult(0));
                for (int i = 1; i < list.getSize(); i++) {
                    if(list.getMin() > list.getResult(i)){
                        list.setMin(list.getResult(i));
                    }
                }
                break;
            case "max": // Розраховуємо максимум
                for (int i = 0; i < list.getSize(); i++) {
                    if(list.getMax() < list.getResult(i)){
                        list.setMax(list.getResult(i));
                    }
                }
                break;
            case "avg": // Розраховуємо середнє арифметичне
                double avg = 0;
                int i;
                for (i = 0; i < list.getSize(); i++) {
                    avg += list.getResult(i);
                }
                avg = avg / i;
                list.setAvg(avg);
                break;
        }
    }
}
