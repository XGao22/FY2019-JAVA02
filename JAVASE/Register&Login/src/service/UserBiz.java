package service;

import Exception.*;
import user.User;


public interface UserBiz {

    void register(String username, String password, String password2, String name, String email, User users[]) throws RegisterException, LoginException;

    void login(String username, String password, User users[]) throws LoginException;
}
