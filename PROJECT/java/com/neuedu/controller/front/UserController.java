package com.neuedu.controller.front;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-09 16:26
 **/

@RestController
@RequestMapping(value = "/user/", produces = "application/json;charset=utf-8")
public class UserController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("login.do")
    @ResponseBody
    public ServerResponse login(String username, String password, HttpSession session) {

        ServerResponse serverResponse = iUserService.login(username, password);
        if (serverResponse.isSuccess()) {
            session.setAttribute("userLogin", serverResponse.getData());
        }

        return serverResponse;
    }

    @RequestMapping("register.do")
    @ResponseBody
    public ServerResponse register(User user) {

        return iUserService.register(user);
    }

    @RequestMapping("forgetPassword_get_question.do")
    @ResponseBody
    public ServerResponse forgetPassword_get_question(String username) {

        return iUserService.forgetPassword_get_question(username);
    }

    @RequestMapping("forgetPassword_check_answer.do")
    @ResponseBody
    public ServerResponse forgetPassword_check_answer(String username, String question, String answer) {

        return iUserService.forgetPassword_check_anwser(username, question, answer);
    }

    @RequestMapping("forget_reset_password.do")
    @ResponseBody
    public ServerResponse forget_reset_password( String username,String passwordNew,String forgetToken){

        return iUserService.forgetPassword_reset_password(username, passwordNew, forgetToken);
    }

    @RequestMapping("update_information.do")
    @ResponseBody
    public ServerResponse update_information(User user){

        return iUserService.update_information(user);
    }
}
