package com.mycompany.practice;

import java.io.*;

public class Practice {
    public static void main(String[] args) {
        int num = 1541;
        SerializableClass objectToSerialize = new SerializableClass(num, BinaryAlternation(num));
        // Серіалізація об'єкту
        serializeObject(objectToSerialize);

        // Десеріалізація об'єкту
        SerializableClass deserializedObject = deserializeObject();

        // Виведення десеріалізованого об'єкту
        System.out.println("Deserialized object:");
        System.out.println("Number: " + deserializedObject.getNum());
        System.out.println("Result: " + deserializedObject.getResult());
    }

    // Метод для серіалізації об'єкту
    private static void serializeObject(SerializableClass object) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            outputStream.writeObject(object);
            System.out.println("Object serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десеріалізації об'єкту
    private static SerializableClass deserializeObject() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.ser"))) {
            SerializableClass object = (SerializableClass) inputStream.readObject();
            System.out.println("Object deserialized");
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static int BinaryAlternation(int decimalNumber){
        // Перетворення десяткового числа на його двійковий варіант
        String binaryNumber = Integer.toBinaryString(decimalNumber);

        // Підрахунок кількості чергувань 0 та 1
        int alternations = countAlternations(binaryNumber);

        // Виведення результату
        System.out.println("The number of alternations of 0 and 1 in the binary representation of a number " + decimalNumber + " is: " + alternations);
        
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


