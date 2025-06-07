package main;

import java.io.*;
import java.util.Iterator;
import java.util.stream.Stream;

public class IO {
    File record = new File("bookRecord.txt");

    public void setRecord(File record) {

    }
    public String readRecord() {
        if (!record.isFile()) {
            try {
                if (!record.createNewFile()) {
                    System.out.println("创建文件失败！");
                }
            } catch (IOException e) {
                System.out.println("读取文件失败！");
            }
        }
        try (
            FileReader fr = new FileReader(record);
            BufferedReader br = new BufferedReader(fr)
        ) {
            Iterator<String> is = br.lines().iterator();
            while (is.hasNext()) {
                String line = is.next();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("读取失败！");
        }
        return "";
    }
}
