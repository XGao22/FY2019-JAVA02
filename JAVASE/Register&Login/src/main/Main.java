package main;

import user.User;
import view.impl._UserView;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User users[] = new User[3];
        initUser(users);
        operation(users);
    }

    static void initUser(User users[]) {
        /**
         * @Description:
         * @Param: [users]
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/26 0026
         */
        User user1 = new User();
        User user2 = new User();

        user1.setUsername("admin");
        user1.setPassword("admin");
        user1.setName("Administrator");
        user1.setEmail("admin@123.com");

        user2.setUsername("tom");
        user2.setPassword("cat");
        user2.setName("tomcat");
        user2.setEmail("tomcat@cat.com");

        users[0] = user1;
        users[1] = user2;
    }

    public static void operation(User users[]) {

        /**
         * @Description:
         * @Param: []
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/26 0026
         */
        _UserView userView = new _UserView();
        Scanner sc = new Scanner(System.in);
        System.out.println("===================请按照提示进行操作=====================");
        System.out.println("1.登陆   2.注册   3.退出系统");
        System.out.println("=========================================================");
        System.out.print("请输入：");
        int firstOperation = 0;
        try {
            firstOperation = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("请输入数字！");
            operation(users);
            return;
        }
        if (firstOperation == 1) {
            userView.login(users);
        } else if (firstOperation == 2) {
            userView.register(users);
        } else if (firstOperation == 3) {
            System.exit(0);
        } else {
            System.out.print("输入错误，请再次输入：");
            operation(users);
        }
        return;
    }

}


