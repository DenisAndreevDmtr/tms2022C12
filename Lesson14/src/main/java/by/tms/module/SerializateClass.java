package by.tms.module;

import lombok.experimental.UtilityClass;

import java.io.*;

@UtilityClass
public class SerializateClass {
    public static void serializateObject(Object object, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Object deSerializateObject(File file) {
        Object object = new Object();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            object = (Car) ois.readObject();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return object;
    }


}
