package service.impl;

import service.UserBiz;
import Exception.*;
import user.User;


/**
 * @program: Register&Login
 * @description
 * @author: X.Gao
 * @create: 2019-03-28 14:45
 **/
public class _UserBiz implements UserBiz {

    @Override
    public void register(String username, String password, String password2, String name, String email, User users[]) throws RegisterException, LoginException {

        /**
         * @Description:
         * @Param: [username, password, password2, name, email, users]
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/28 0028
         */
        User user = new User();
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (i == users.length - 1) {
                    throw new LoginException("满了，不要再注册了！");
                }
                continue;
            } else {
                break;
            }
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (username.equals(users[i].getUsername())) {
                    throw new RegisterException("有人叫 " + username + " 了，不行！！！");
                }
                continue;
            } else {
                continue;
            }
        }

        if (password.equals(password2)) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setName(name);
                    user.setEmail(email);
                    users[i] = user;
                    System.out.println("注册成功！！！");
                    return;
                } else {
                    continue;
                }
            }
        } else {
            throw new RegisterException("两次密码不一样，不行！！！");
        }
    }

    @Override
    public void login(String username, String password, User users[]) throws LoginException {

        /**
         * @Description:
         * @Param: [username, password, users]
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/28 0028
         */
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                if (i == users.length - 1) {
                    throw new LoginException("用户名不存在！");
                }
                continue;
            }
            if (username.equals(users[i].getUsername())) {
                if (password.equals(users[i].getPassword())) {
                    System.out.println("欢迎您" + username);
                    break;
                } else {
                    throw new LoginException("密码错误！");
                }
            } else {
                if (i == users.length - 1) {
                    throw new LoginException("用户名不存在！");
                }
            }
        }
    }
}
