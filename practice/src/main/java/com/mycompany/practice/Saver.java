package com.mycompany.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Клас, який містить в собі серіалізацію(save) та десиріалізацію(load)
 */
public class Saver {
    public static void save(CollectionClass object) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            outputStream.writeObject(object);
            //System.out.println("Object serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static CollectionClass load() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.ser"))) {
            CollectionClass object = (CollectionClass) inputStream.readObject();
            //System.out.println("Object deserialized");
            return object;
        } catch (FileNotFoundException e) {
            System.out.println("\nFile with results is doesn't exist.");
            texts.Return();
            return null;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}