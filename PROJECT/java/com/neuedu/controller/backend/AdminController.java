package com.neuedu.controller.backend;

import com.neuedu.common.ServerResponse;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-14 09:19
 **/

@RestController
@RequestMapping("/manage/user/")
public class AdminController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("login.do")
    public ServerResponse adminLogin(String username, String password, int role, HttpSession session) {

        ServerResponse serverResponse = iUserService.adminLogin(username, password, role);
        if (serverResponse.isSuccess()) {
            session.setAttribute("adminLogin", serverResponse.getData());
        }

        return serverResponse;
    }
}
