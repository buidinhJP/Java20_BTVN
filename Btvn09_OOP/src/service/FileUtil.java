package service;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileUtil implements Serializable {
    public static <T> void writeDataToFile(List<T> data, String filename){
        if (DataUtil.isEmptyCollection(data)){
            return;
        }

        do {
            if (!StringUtil.isEmptyString(filename)){
                break;
            }
            System.out.print("Tên file không được để trống! Nhập lại: ");
            filename = new Scanner(System.in).nextLine();
        }while (true);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List readDataFromFile(String filename){
        if (!StringUtil.isEmptyString(filename)){
            return null;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (List) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}