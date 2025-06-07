package main;

import main.utils.Menu;

import java.util.ArrayList;
import java.util.Scanner;


public class LaomaCore {
    public static boolean exit = false;
    public static ArrayList<Menu> history = new ArrayList<>();
    public static IO io = new IO();

    static Scanner scan = new Scanner(System.in);

    static Menu lastMenu;
    static Menu currentMenu = Menu.MAIN_MENU;
    static int addStat = 0; // 0: NAME 1: AUTHOR 2: PRESS 3: INTRO
    static Book book;

    private static String menuManager() {
        StringBuilder output = new StringBuilder();
        switch (currentMenu) {
            case MAIN_MENU:
                output.append("""
                        欢迎来到牢马书城2.0版本
                        这里有最新最热最好康的各种读物
                        1.书籍查看
                        2.书籍上架
                        3.书籍下架
                        4.退出应用
                        请输入序号选择功能
                        """);
                break;
            case SHOW_BOOK:
                output.append("""
                        >>>>1.书籍查看
                        """);
                int i = 1;
                for (Book book : BookManager.getBookList()) {
                    output.append("(").append(i).append(")");
                    output.append(book.getBookInformation());
                    i++;
                }
                break;
            case ADD_BOOK:
                output.append("""
                        >>>>2.书籍上架
                        """);
                switch (addStat) {
                    case 0:
                        output.append("请输入书名：");
                        break;
                    case 1:
                        output.append("请输入作者：");
                        break;
                    case 2:
                        output.append("请输入出版社：");
                        break;
                    case 3:
                        output.append("请输入介绍：");
                        break;
                }
                break;
            case DEL_BOOK:
                output.append("""
                        >>>>3.书籍下架
                        请输入你要下架的书名
                        """);
                break;
        }
        return output.toString();
    }

    public static void main(String[] arg) throws InterruptedException {
        io.readRecord();


        int choice = -1;
        while (!exit) {
            TypeWriter.typeWriter(menuManager());
            String input = scan.nextLine();
            try {
                choice = Integer.parseInt(input);
            }catch(NumberFormatException e) {
                if(currentMenu != Menu.ADD_BOOK && currentMenu != Menu.DEL_BOOK) {
                    System.out.println("泥输入错了");
                    continue;
                }
            }

            lastMenu = currentMenu;

            switch (currentMenu) {
                case MAIN_MENU:
                    switch (choice) {
                        case 0:
                        case 1:
                            currentMenu = Menu.SHOW_BOOK;
                            break;
                        case 2:
                            currentMenu = Menu.ADD_BOOK;
                            addStat = 0;
                            book = new Book();
                            break;
                        case 3:
                            currentMenu = Menu.DEL_BOOK;
                            break;
                        case 4:
                            exit = true;
                            TypeWriter.typeWriter("溜了溜了....");
                            break;
                    }

                    break;
                case SHOW_BOOK:
                    // 按照下标阅读指定书籍等
                    if (choice == 0) {
                        currentMenu = Menu.MAIN_MENU;
                    }
                    break;
                case ADD_BOOK:
                    switch (addStat) {
                        case 0:
                            book.setBookName(input);
                            break;
                        case 1:
                            book.setAuthorName(input);
                            break;
                        case 2:
                            book.setPress(input);
                            break;
                        case 3:
                            book.setIntroduction(input);
                            BookManager.addBook(book);
                            System.out.println("添加成功！");
                            currentMenu = Menu.MAIN_MENU; // 返回主菜单
                            break;
                    }
                    addStat ++;
                    break;
                case DEL_BOOK:
                    BookManager.delBook(choice - 1);
                    currentMenu = Menu.MAIN_MENU;
                    break;
            }
            if (exit) {
                break;
            }
        }
    }
}
