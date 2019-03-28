package view.impl;

import main.Main;
import service.impl._UserBiz;
import view.UserView;
import Exception.*;
import user.*;

import java.util.Scanner;

/**
 * @program: Register&Login
 * @description
 * @author: X.Gao
 * @create: 2019-03-28 14:47
 **/
public class _UserView implements UserView {

    @Override
    public void login(User users[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String username = sc.next();

        System.out.print("请输入密码：");
        String password = sc.next();

        try {
            new _UserBiz().login(username, password, users);
        } catch (LoginException le) {
            System.out.print(le.getMessage());
            System.out.println("请重新输入用户名或密码:");
            this.login(users);
            return;
        }
        System.out.println("登陆成功，欢迎您" + username);
        Main.operation(users);
    }

    @Override
    public void register(User users[]) {
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

        try {
            new _UserBiz().register(username, password, password2, name, email, users);
        }catch (RegisterException re){
            System.out.print(re.getMessage());
            System.out.println("请重新注册：");
            this.register(users);
            return;
        }catch (LoginException le){
            System.out.print(le.getMessage());
            System.out.println("请登陆：");
            this.login(users);
            return;
        }


        System.out.println("注册成功，返回选择界面！");
        Main.operation(users);
    }
}
