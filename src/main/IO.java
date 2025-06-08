package main;

import java.io.*;
import java.util.ArrayList;

public class IO {
    File record = new File("bookRecord.txt");

    public void saveRecord() {
        try (FileOutputStream fis = new FileOutputStream(record);
            ObjectOutputStream ois = new ObjectOutputStream(fis)
            ){
            ois.writeObject(BookManager.bookList);
        }catch (IOException e) {
            System.out.println("1");
        }
    }
    public void readRecord() {
        if (!record.isFile()) {
            saveRecord();
        }
        try (
            FileInputStream fis = new FileInputStream(record);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Object obj = ois.readObject();
            if (obj == null) {
                return;
            }
            BookManager.bookList = (ArrayList<Book>) obj;
        } catch (Exception e) {
            System.out.println("读取失败！");
        }
    }
}
