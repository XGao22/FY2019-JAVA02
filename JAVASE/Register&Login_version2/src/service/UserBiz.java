package service;

import Exception.*;
import user.User;

import java.util.List;


public interface UserBiz {

    void register(String username, String password, String password2, String name, String email, List users, int i) throws RegisterException, LoginException;

    void login(String username, String password, List users) throws LoginException;
}
