package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class BookLibrary {
    //存储书籍
    private static final ArrayList<String> bookList = new ArrayList<>(Arrays.asList(
            "是笨蛋捏", "喵喵喵喵喵喵喵", "History"
    ));

    public static ArrayList<String> getBookList() {
        return bookList;
    }
    public static ArrayList<String> addBook(String name) throws Exception {
        if (bookList.contains(name)) {
            throw new Exception("already in");
        }
        return bookList;
    }
}
