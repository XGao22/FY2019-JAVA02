package Interface;

import Exception.*;


public interface UserBiz {

    void register(String username, String password, String password2, String name, String email) throws RegisterException;

    void login(String username, String password) throws LoginException;
}
