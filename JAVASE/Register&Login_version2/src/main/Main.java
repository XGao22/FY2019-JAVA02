package main;

import user.User;
import view.impl._UserView;

import java.util.*;

import Enum.EnumChoice;

public class Main {

    public static void main(String[] args) {
//        User users[] = new User[5];
        List users = new ArrayList();
        initUser(users);
        operation(users);
    }

    static void initUser(List users) {
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
        user1.setId(4);

        user2.setUsername("tom");
        user2.setPassword("cat");
        user2.setName("tomcat");
        user2.setEmail("tomcat@cat.com");
        user2.setId(2);

        users.add(user1);
        users.add(user2);
//        System.out.println(user1);
//        System.out.println(user2);
    }

    public static void operation(List users) {

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
        System.out.println("a.登陆   b.注册   c.退出系统 d.排序");
        System.out.println("=========================================================");
        System.out.print("请输入：");
        String firstOperation = null;
        String _operation = sc.next();
        if (_operation.equals("a")) {
            firstOperation = EnumChoice.a.getChoice().toString();
        } else if (_operation.equals("b")) {
            firstOperation = EnumChoice.b.getChoice().toString();
        } else if (_operation.equals("c")) {
            firstOperation = EnumChoice.c.getChoice().toString();
        } else if (_operation.equals("d")) {
            firstOperation = EnumChoice.d.getChoice().toString();
        } else {
            System.out.println("输入错误，请重新输入：");
            operation(users);
        }
        if (firstOperation.equals("1")) {
            userView.login(users);
        } else if (firstOperation.equals("2")) {
            userView.register(users);
        } else if (firstOperation.equals("3")) {
            System.exit(0);
        } else if (firstOperation.equals("4")) {
            Collections.sort(users);
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()){
                User u = iterator.next();
                System.out.println(u);
            }
        } else {
            System.out.print("输入错误，请再次输入：");
            operation(users);
        }
        return;
    }

}


