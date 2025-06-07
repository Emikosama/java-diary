import utils.BookLibrary;

import java.io.IOException;
import java.util.*;

/**
 * 这是一个书城项目，要达到的效果有：
 * 1. 书籍的展示
 * 2. 书籍的上新与下架
 * 3. 退出
 * 包含的技能点有：
 * 1. 用户交互——输入与输出
 * 2. 分支结构，循环结构
 * 3. 错误处理
 * 4. 面向对象的封装方法
 * 5. 集合的使用
 */
/*main 0
* |    |     |    |
* show add  del  esc 1
* | |  |  |  | |  |  |
*                      2
* level = 0;
* row = xxx;
* map[show,(1,1),add,(1,2),del,(1,3)]
* */
public class mainDemo {
    static ArrayList<String> bookList = BookLibrary.getBookList();
    //获取用户输入
    static Scanner input = new Scanner(System.in);
    static int menuIndex;
    //菜单选择器
    private static void menuChoicer(int menuIndex) {
        mainDemo.menuIndex = menuIndex;
        switch(menuIndex) {
            case 1:
                String mainMenu = """
                        欢迎来到牢马书城
                        1.展示书籍
                        2.上新书籍
                        3.下架书籍
                        4.退出应用
                        请输入你想进入的功能序号
                        """;
                System.out.print(mainMenu);
                break;
            case 2:
                StringBuilder showBooks = new StringBuilder("""
                        >> 猫猫书籍大全
                           你想看的这里都有！
                        """);
                for (int i = 0; i < bookList.size(); i ++) {
                    showBooks
                            .append(i + 1)
                            .append(". 《")
                            .append(bookList.get(i))
                            .append("》\n");
                }
                showBooks.append("输入 0 返回");
                System.out.println(showBooks);
                break;
            case 3:
                StringBuilder addBooks = new StringBuilder("""
                        >> 请输入你要上架的书籍名称
                        """);
                System.out.println(addBooks);
                break;
            case 4:
                StringBuilder delBooks = new StringBuilder("""
                        >> 请输入你要下架的书籍名称
                        """);
                System.out.println(delBooks);
                break;
        }
    }

    public static void main(String[] args) {

        //调用菜单选择
        int choice;
        String line;
        boolean exited = false;
        //载入主菜单

        /*循环{
        等待用户输入

        }*/
        while (!exited) {
            menuChoicer(1);
            line = input.nextLine();
            try {
                choice = Integer.parseInt(line);
                if (choice > 4){
                    throw new Exception("heihei");
                }
            } catch (Exception ex) {
                System.out.println("输入错误，请输入正确的序号数字！");
                continue;
            }
            switch (choice) {
                //输入 0 返回主菜单
                case 0:
                    menuChoicer(1);
                    break;
                case 1:
                    while (choice > 0){
                        menuChoicer(2);
                        line = input.nextLine();
                        choice = Integer.parseInt(line);
                        if (choice == 0){
                            break;
                        }else {
                            System.out.println("输入有误，请重试");

                        }
                    }
                    break;
                case 2:
                    menuChoicer(3);
                    line = input.nextLine();
                    if (bookList.contains(line)){
                        System.out.println("您的书 已经 上架 ！");
                    }else{
                        bookList.add(line);
                        System.out.println("添加成功，已返回主页");
                    }
                    break;
                case 3:
                    menuChoicer(4);
                    line = input.nextLine();
                    if (!bookList.contains(line)){
                        System.out.println("未找到你要下架的书！已返回主页");
                    }else{
                        bookList.remove(line);
                        System.out.println("下架成功，已返回主页");
                    }
                    break;
                //退出程序
                case 4:
                    exited = true;
                    System.out.println("核心熔毁，正在退退退良......");
                    break;
            }
        }
    }
}
