package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-09 16:26
 **/


public interface IUserService {

    ServerResponse login(String username, String password);

    ServerResponse register(User user);

    ServerResponse forgetPassword_get_question(String username);

    ServerResponse forgetPassword_check_anwser(String username, String question, String anwser);

    ServerResponse forgetPassword_reset_password(String username, String passwordNew, String forgetToken);

    ServerResponse update_information(User user);

    ServerResponse adminLogin(String username, String password, int role);
}
