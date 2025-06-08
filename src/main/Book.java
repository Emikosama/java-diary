package main;

import java.io.Serializable;

/**
 * 书籍信息
 */
public class Book implements Serializable {
    private String bookName;
    private String authorName;
    private String press;            //出版社
    private String introduction;     //介绍

    public void setPress(String press) {
        this.press = press;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookInformation() {
        return "书名：" + bookName + "," +
                "作者：" + authorName + "," +
                "出版社：" + press + "," +
                "简介：" + introduction + "\n";
    }

    public Book(String bookName, String authorName, String press, String introduction) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.press = press;
        this.introduction = introduction;

    }
    public Book() {

    }
}
