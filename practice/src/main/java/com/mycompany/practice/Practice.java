package com.mycompany.practice;

import java.io.*;
import java.util.Scanner;

public class Practice {
    /**
     * Цей клас є <l>основним</l>.
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
            System.out.println("'0' - show results and stop program.");
            System.out.println("'1' - show results.");
            System.out.println("'2' - change your decimal number to binary and count alternations of 0 and 1.");
            System.out.print("\nType: ");
            int userInput = scanner.nextInt();
            switch(userInput){
                case 0: results = load(); results.getResults(); i = 0; break;   // Закриваємо програму і показуємо результати
                case 1: results = load(); results.getResults(); break;  // Показуємо результати
                case 2: System.out.print("\nYour number: ");    // Знаходимо кількість з
                    int num = scanner.nextInt();
                    results.addResult(BinaryAlternation(num));
                    save(results);
                    break;
                default: System.out.print("\n\n"); break;
            }
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
    private static CollectionClass load() {
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
        System.out.println("The number of alternations of 0 and 1 in the binary representation of a number " + decimalNumber + " is: " + alternations);
        
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


