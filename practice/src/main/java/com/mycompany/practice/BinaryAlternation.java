package com.mycompany.practice;

public class BinaryAlternation {
    public static void main(String[] args) {
        int decimalNumber = 42; // Ваше задане десяткове число

        // Перетворення десяткового числа на його двійкове представлення
        String binaryNumber = Integer.toBinaryString(decimalNumber);

        // Підрахунок кількості чергувань 0 та 1
        int alternations = countAlternations(binaryNumber);

        // Виведення результату
        System.out.println("Кількість чергувань 0 та 1 у двійковому представленні числа " + decimalNumber + " становить: " + alternations);
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
