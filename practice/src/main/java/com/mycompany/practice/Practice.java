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
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("'0' - stop program.");
            System.out.println("'1' - show results.");
            System.out.println("'2' - change your decimal number to binary and count alternations of 0 and 1.");
            System.out.print("\nType: ");
            int userInput = scanner.nextInt();
            
            switch(userInput){
                case 0: i = 0; break;   // Завершуємо програму
                case 1: results = load();   // Показуємо результати
                    chooseDisplay(1, results);
                    break;  
                case 2: System.out.print("\nYour number: ");    // Знаходимо кількість чергувань 0 та 1 десяткового числа, перетвореного в двійковий варіант
                    int num = scanner.nextInt();
                    results.addResult(BinaryAlternation(num));
                    save(results);
                    break;
                default: System.out.print("\n\n"); break;
            }
        }
    }

    private static void chooseDisplay(int i, CollectionClass results){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n'0' - show only results.");
        System.out.println("'1' - show results and their indexes.");
        System.out.print("\nType: ");
        int userInput = scanner.nextInt();
        System.out.println();
        
        switch(userInput){
            case 0: Factory Results = new ResultsFactory();
                Collection listResults = Results.factoryMethod();
                listResults.display(results);
                i = 0;
                return;
            case 1: Factory All = new AllFactory();
                Collection listAll = All.factoryMethod();
                listAll.display(results);
                return;
            default: return;
        }
    }
    
    // Метод для серіалізації об'єкту
    private static void save(CollectionClass object) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            outputStream.writeObject(object);
            //System.out.println("Object serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десеріалізації об'єкту
    public static CollectionClass load() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.ser"))) {
            CollectionClass object = (CollectionClass) inputStream.readObject();
            //System.out.println("Object deserialized");
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
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


