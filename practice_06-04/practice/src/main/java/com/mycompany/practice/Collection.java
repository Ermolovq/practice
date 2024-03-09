package com.mycompany.practice;
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
            System.out.println("Список результатів порожній. \nПовертаємося до головного меню...\n");
            return;
        }
        
        // Обчислення кількості рядків таблиці
        int rows = (int) Math.ceil((double) list.getSize() / 4);
        
        // Виведення значень масиву у вигляді таблиці
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < 4; j++) {
                int c = i * 4 + j; // Обчислення індексу поточного елементу масиву
                if (c < list.getSize()) {
                    System.out.print(list.getResult(c) + "\t"); // Виведення значення елемента
                }else{
                    System.out.print("\t"); // Виведення пустої комірки, якщо елементи закінчилися
                }
            }
            System.out.println("");
        }
    }
    @Override
    public void drawTable(CollectionClass list, String type){
        if(list.getSize() == 0){
            System.out.println("Список результатів порожній. \nПовертаємося до головного меню...\n");
            return;
        }
        switch(type){
            // Таблиця з індексами до результатів(початок від 1)
            case "default" -> {
                int rows = (int) Math.ceil((double) list.getSize() / 4);
                
                for(int i = 0; i < rows; i++){
                    for (int j = 0; j < 4; j++) {
                        int c = i * 4 + j;
                        if (c < list.getSize()) {
                            System.out.print((c + 1) + ". " + list.getResult(c) + "\t");
                        }else{
                            System.out.print("\t");
                        }
                    }
                    System.out.println("");
                }
            }
            // Така ж таблиця, але з виділенням
            case "border" -> {
                System.out.println("------------------------------");
                
                int rows = (int) Math.ceil((double) list.getSize() / 4);
                
                for(int i = 0; i < rows; i++){
                    for (int j = 0; j < 4; j++) {
                        int c = i * 4 + j;
                        if (c < list.getSize()) {
                            System.out.print((c + 1) + ". " + list.getResult(c) + "\t");
                        }else{
                            System.out.print("\t");
                        }
                    }
                    System.out.println("");
                }
                System.out.println("------------------------------");
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