import Interface.*;
import Exception.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User users[] = new User[5];
        initUser(users);
        operation();
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

    static void operation() {

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
        }catch (InputMismatchException ime){
            System.out.println("请输入数字！");
            operation();
            return;
        }
        if (firstOperation == 1) {
            userView.login();
        } else if (firstOperation == 2) {
            userView.register();
        } else if (firstOperation == 3) {
            System.exit(0);
        } else {
            System.out.print("输入错误，请再次输入：");
            operation();
        }
        return;
    }

}


class _UserBiz implements UserBiz {

    @Override
    public void register(String username, String password, String password2, String name, String email) throws RegisterException {

    }

    @Override
    public void login(String username, String password) throws LoginException {
        if (username.equals("admin") & password.equals("admin")) {
            System.out.println("欢迎您" + username);
        } else if (username.equals("tom") & password.equals("cat")) {
            System.out.println("欢迎您" + username);
        } else {
            throw new LoginException("用户名不存在或密码错误！");
        }
    }
}

class _UserView implements UserView {

    @Override
    public void login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String username = sc.next();

        System.out.print("请输入密码：");
        String password = sc.next();

        try {
            new _UserBiz().login(username, password);
        } catch (LoginException le) {
            System.out.println("请重新输入用户名或密码:");
            this.login();
            return;
        }
        System.out.println("登陆成功，欢迎您" + username);
        Main.operation();
    }

    @Override
    public void register() {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String username = sc.next();

        System.out.print("请输入密码：");
        String password = sc.next();

        System.out.print("请再次输入密码：");
        String password2 = sc.next();

        System.out.print("请输入真实姓名：");
        String name = sc.next();

        System.out.print("请输入邮箱：");
        String email = sc.next();

        System.out.println("注册成功，返回选择界面！");
        Main.operation();
    }
}
