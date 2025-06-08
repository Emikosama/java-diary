package main;

import java.util.ArrayList;

public class BookManager {
    public static ArrayList<Book> bookList = new ArrayList<>();

    public static void addBook(Book book) {
        bookList.add(book);
    }
    public static void delBook(int bookIndex) {
        if (bookIndex < 0 || bookIndex > bookList.size()) {
            System.out.println("泥的书在哪呢？沃找不到");
            return;
        }
        Book book = bookList.get(bookIndex);
        bookList.remove(book);
        System.out.println("删除成功，欧拉欧拉欧拉");
    }
    public static ArrayList<Book> getBookList() {
        return bookList;
    }
    public BookManager() {

    }
}
