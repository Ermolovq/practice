package com.mycompany.practice;

import java.util.Scanner;

/**
 * Клас, що реалізує меню, використовуючи шаблон Singleton
 */
public class Menu {
    private static Menu instance;
    
    private Menu(){};
    
    public static Menu getInstance(){
        if(instance == null){
            instance = new Menu();
        }
        return instance;
    }
    
    // Метод для виведення меню користувачу
    public static void showStartMenu(){
        Scanner scanner = new Scanner(System.in);

        int i = -1;
        CollectionClass results = new CollectionClass();
        
        while(i != 0){
            System.out.println("\n------------------------------------------------------------------------------------");
            System.out.println("'0' - stop program.");
            System.out.println("'1' - show results.");
            System.out.println("'2' - change your decimal number to binary and count alternations of 0 and 1.");
            System.out.print("\nType: ");
            int userInput = scanner.nextInt();
            switch(userInput){
                case 0 -> i = 0;    // Завершуємо програму
                case 1 -> { // Показуємо результати
                    results = Saver.load();
                    chooseDisplay(results);
                }
                case 2 -> { // Відтворюємо BinaryAlternation
                    System.out.println("\nType anything other than numbers to return to start menu.");
                    System.out.println("\nType: ");    // Відтворюємо метод підрахунку кількості чергувань 0 та 1
                    String input = scanner.next();
                    try {   // Перевіряємо введені дані на можливість перетворення в int
                        int num = Integer.parseInt(input);
                        results.addResult(BinaryAlternation.count(num));
                        Saver.save(results);
                    } catch (NumberFormatException e){  // Інакше повертаємося до головного меню
                        texts.Return();
                    }
                }
                default -> texts.Return();    // Повертаємося до головного меню
            }
        }
    }
    
    // Метод виведення меню користувачу, в якому він зможе вибрати один з варіантів таблиць
    private static void chooseDisplay(CollectionClass results){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n'0' - show default table.");
        System.out.println("'1' - show table with indexes.");
        System.out.println("'2' - show table with indexes and two borders.");
        System.out.println("anything other - return to start menu.");
        System.out.print("\nType: ");
        String input = scanner.next();
        try {   // Перевіряємо введені дані на можливість перетворення в int
            int num = Integer.parseInt(input);
            System.out.println();
            switch(num){
                case 0 -> { // Виводимо таблицю тільки з результатами
                    Factory Table = new TableFactory();
                    Collection table = Table.factoryMethod();
                    table.drawTable(results);
                }
                case 1 -> { // Виводимо таблицю з результатами та їх індексом, починаючи від 1
                    Factory Table = new TableFactory();
                    Collection table = Table.factoryMethod();
                    table.drawTable(results, "default");
                }
                case 2 -> { // Виводимо попередню таблицю з двома границями
                    Factory Table = new TableFactory();
                    Collection table = Table.factoryMethod();
                    table.drawTable(results, "border");
                }
                default -> texts.Return();  // Повертаємося до головного меню
            }
        } catch (NumberFormatException e){  // Інакше повертаємося до головного меню
            texts.Return();
        }
    }
}