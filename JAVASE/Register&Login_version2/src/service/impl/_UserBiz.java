package service.impl;

import jdk.nashorn.internal.ir.WhileNode;
import service.UserBiz;
import Exception.*;
import user.User;

import java.util.Iterator;
import java.util.List;


/**
 * @program: Register&Login
 * @description
 * @author: X.Gao
 * @create: 2019-03-28 14:45
 **/
public class _UserBiz implements UserBiz {

    @Override
    public void register(String username, String password, String password2, String name, String email, List users, int id) throws RegisterException, LoginException {

        /**
         * @Description:
         * @Param: [username, password, password2, name, email, users]
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/28 0028
         */
        User user = new User();

        for (int i = 0; i < users.size(); i++) {
            User _user = (User) users.get(i);
            if (username.equals(_user.getUsername())) {
                throw new RegisterException("有人叫 " + username + " 了，不行！！！");
            } else {
                if (i == users.size() - 1) {
                    if (password.equals(password2)) {
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setName(name);
                        user.setEmail(email);
                        user.setId(id);
                        users.add(user);
                        System.out.println("注册成功！！！");
                        return;
                    } else {
                        throw new RegisterException("两次密码不一样，不行！！！");
                    }
                }
            }
        }
    }

    @Override
    public void login(String username, String password, List users) throws LoginException {

        /**
         * @Description:
         * @Param: [username, password, users]
         * @return: void
         * @Author: X.Gao
         * @Date: 2019/3/28 0028
         */
        Iterator iterator = users.iterator();
        while (iterator.hasNext()) {
            User _user = (User) iterator.next();
            if (username.equals(_user.getUsername())) {
                if (password.equals(_user.getPassword())) {
                    System.out.println("欢迎您" + username);
                    break;
                } else {
                    throw new LoginException("密码错误！");
                }
            } else {
                if (iterator.hasNext()) {
                    continue;
                } else {
                    throw new LoginException("用户名不存在！");
                }
            }
        }
    }
}
