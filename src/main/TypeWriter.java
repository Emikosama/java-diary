package main;

import static java.lang.Thread.sleep;

public class TypeWriter {

    public static void typeWriter(String string) throws InterruptedException {
        for (int i = 0; i < string.length(); i ++) {
            char ch = string.charAt(i);
            System.out.print(ch);
            Thread.sleep(20);
        }
    }
    public TypeWriter() {

    }
}
