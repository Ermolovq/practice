package com.mycompany.practice;

import java.io.*;
import java.util.Scanner;

public class Practice {
    /**
     * Цей клаc є оновним.
     * Виводить в консоль меню з переліком функцій.
     * Містить в собі код з серіалізацією та десеріалізацію класу CollectionClass(save/load).
     * Також містить в собі метод знаходження кількості чергувань 0 та 1 у двійковому варіанті числа.
     * @param args 
     */
    public static void main(String[] args) {
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
                case 0 -> i = 0;
                // Завершуємо програму
                case 1 -> {
                    results = Saver.load();   // Показуємо результати
                    chooseDisplay(results);
                }
                case 2 -> {
                    System.out.print("\nYour number: ");    // Відтворюємо метод підрахунку кількості чергувань 0 та 1
                    int num = scanner.nextInt();
                    results.addResult(BinaryAlternation(num));
                    Saver.save(results);
                }
                default -> System.out.print("\n\n");
            }
        }
    }

    private static void chooseDisplay(CollectionClass results){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n'0' - show default table.");
        System.out.println("'1' - show table with indexes.");
        System.out.println("'2' - show table with indexes and two borders.");
        System.out.println("another - return.");
        System.out.print("\nType: ");
        int userInput = scanner.nextInt();
        System.out.println();
        switch(userInput){
            case 0 -> {
                Factory Table = new TableFactory();
                Collection table = Table.factoryMethod();
                table.drawTable(results);
            }
            case 1 -> {
                Factory Table = new TableFactory();
                Collection table = Table.factoryMethod();
                table.drawTable(results, "default");
            }
            case 2 -> {
                Factory Table = new TableFactory();
                Collection table = Table.factoryMethod();
                table.drawTable(results, "border");
            }
        }
    }
    
    public static String BinaryAlternation(int decimalNumber){
        // Перетворення десяткового числа на його двійковий варіант
        String binaryNumber = Integer.toBinaryString(decimalNumber);

        // Підрахунок кількості чергувань 0 та 1
        int alternations = countAlternations(binaryNumber);

        // Виведення результату
        System.out.println("The number of alternations of 0 and 1 in the binary representation of a number " + decimalNumber + " is " + alternations);
        
        return String.format("%d", alternations);
    }

    // Метод для підрахунку кількості чергувань 0 та 1
    private static int countAlternations(String binaryNumber) {
        int alternations = 0;

        // Проходимося по кожному біту у двійковому представленні
        for (int i = 1; i < binaryNumber.length(); i++) {
            // Якщо поточний біт відрізняється від попереднього, збільшуємо лічильник чергувань
            if (binaryNumber.charAt(i) != binaryNumber.charAt(i - 1)) {
                alternations++;
            }
        }
        
        return alternations;
    }
    
}


