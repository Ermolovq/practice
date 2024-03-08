package com.mycompany.practice;

/**
 * Клас, який перетворює десяткове число в його двійковий варіант,
 * а потім знаходить кількість чергувань 0 та 1 в ньому
 */
public class BinaryAlternation {
    // Метод для виведення результату підрахунку чергувань
    public static int count(int decimalNumber) {
        // Перетворення десяткового числа на його двійковий варіант
        String binaryNumber = Integer.toBinaryString(decimalNumber);

        // Підрахунок кількості чергувань 0 та 1
        int alternations = countAlternations(binaryNumber);

        // Виведення результату
        System.out.println("The number of alternations of 0 and 1 in the binary representation of a number " + decimalNumber + " is " + alternations);
        
        return alternations;
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
