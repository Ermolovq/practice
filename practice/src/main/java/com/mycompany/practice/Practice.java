package com.mycompany.practice;

import java.io.*;

public class Practice {
    public static void main(String[] args) {
        float num = 1540;
        SerializableClass objectToSerialize = new SerializableClass(num, 0);

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
}


