package com.mycompany.practice;
/**
 * Інтерйфейс, що реалізує FactoryMethod
 */
public interface Collection {
    void display(CollectionClass list);
}

class All implements Collection {
    @Override
    public void display(CollectionClass list){
        for(int i = 0; i < list.getSize(); i++){
            System.out.println((i + 1) + " result = " + list.getResult(i));
        }
        System.out.println();
    }
}

class Results implements Collection {
    @Override
    public void display(CollectionClass list){
        for(int i = 0; i < list.getSize(); i++){
            System.out.print(list.getResult(i) + " ");
        }
        System.out.println();
    }
}

interface Factory {
    Collection factoryMethod();
}

class AllFactory implements Factory {
    @Override
    public Collection factoryMethod(){
        return new All();
    }
}

class ResultsFactory implements Factory {
    @Override
    public Collection factoryMethod(){
        return new Results();
    }
}