package com.neuedu.service.impl;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.common.UserRoleEnum;
import com.neuedu.dao.UserMapper;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.utils.MD5Utils;
import com.neuedu.utils.TokenCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-09 16:26
 **/

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse login(String username, String password) {

        //参数非空校验
        if (username == null || username.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_USERNAME_EMPTY, "用户名为空");
        }
        if (password == null || password.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_PASSWORD_EMPTY, "密码为空");
        }
        //检查用户名是否存在
        int checkUsernameExist = userMapper.checkUsernameExist(username);
        if (checkUsernameExist <= 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_USERNAME_NOT_EXIST, "用户名不存在");
        }
        //根据用户名密码查找信息
        password = MD5Utils.getMD5Code(password);
        User checkLoginResult = userMapper.checkByUsernameAndPassword(username, password);
        if (checkLoginResult == null) {

            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_LOGIN_FAIL, "登录失败");
        }
        //返回结果
        return ServerResponse.createServerResponseBySuccess("登录成功", checkLoginResult);
    }

    @Override
    public ServerResponse register(User user) {

        //参数校验
        if (user == null) {
            return ServerResponse.createServerResponseByFail(Const.USER_REGISTER_PARAM_EMPTY, "参数不能为空！");
        }

        //判断用户名是否存在
        int result_username = userMapper.checkUsernameExist(user.getUsername());
        if (result_username > 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_REGISTER_USERNAME_EXIST, "用户名已存在");
        }

        //判断邮箱是否存在
        int result_email = userMapper.checkUsernameExist(user.getEmail());
        if (result_email > 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_REGISTER_EMAIL_EXIST, "邮箱已存在");
        }

        //密码加密
        user.setPassword(MD5Utils.getMD5Code(user.getPassword()));

        //设置角色
        user.setRole(UserRoleEnum.ROLE_USER.getRole());

        //注册
        int result_insert = userMapper.insert(user);
        if (result_insert == 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_REGISTER_REGISTER_FAIL, "注册失败");
        }
        return ServerResponse.createServerResponseBySuccess("注册成功");
    }

    @Override
    public ServerResponse forgetPassword_get_question(String username) {

        //参数校验
        if (username == null || username.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_USERNAME_EMPTY, "用户名为空");
        }

        //校验username是否存在
        int checkUsernameExist = userMapper.checkUsernameExist(username);
        if (checkUsernameExist <= 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_USERNAME_NOT_EXIST, "用户名不存在");
        }

        //查询密保问题
        String findQuestion = userMapper.forgetPassword_get_question(username);
        if (findQuestion == null || "".equals(findQuestion)) {
            return ServerResponse.createServerResponseByFail(Const.USER_FORGETPASSWORD_QUESTION_NOT_EXIST, "密保问题不存在");
        }

        return ServerResponse.createServerResponseBySuccess("查询成功", findQuestion);
    }

    @Override
    public ServerResponse forgetPassword_check_anwser(String username, String question, String answer) {

        if (username == null || username.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_FORGETPASSWORD_USERNAME_EMPTY, "用户名不能为空");
        }
        if (question == null || question.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_FORGETPASSWORD_QUESTION_NOT_EXIST, "密保问题不能为空");
        }
        if (answer == null || answer.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_FORGETPASSWORD_ANSWER_EMPTY, "答案不能为空");
        }

        int result = userMapper.forgetPassword_check_answer(username, question, answer);
        if (result <= 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_FORGETPASSWORD_ANSWER_MISTAKE, "答案错误");
        }

        String token = UUID.randomUUID().toString();
        TokenCache.set("username:" + username, token);
        return ServerResponse.createServerResponseBySuccess("回答正确", token);
    }

    @Override
    public ServerResponse forgetPassword_reset_password(String username, String passwordNew, String forgetToken) {

        if (username == null || username.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_RESETPASSWORD_USERNAME_EMPTY, "用户名不能为空");
        }
        if (passwordNew == null || passwordNew.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_RESETPASSWORD_NEWPASSWORD_EMPTY, "新密码不能为空");
        }
        if (forgetToken == null || forgetToken.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_RESETPASSWORD_TOKEN_EMPTY, "token不能为空");
        }

        String token = TokenCache.get("username:" + username);

        if (token == null) {
            return ServerResponse.createServerResponseByFail(Const.USER_RESETPASSWORD_TOKEN_ERROR, "不能修改别人的密码或者token已经过期");
        }
        if (!token.equals(forgetToken)) {
            return ServerResponse.createServerResponseByFail(Const.USER_RESETPASSWORD_TOKEN_ERROR, "无效的token");
        }

        int result = userMapper.forgetPassword_reset_password(username, MD5Utils.getMD5Code(passwordNew));
        if (result <= 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_RESETPASSWORD_FAIL, "密码修改失败");
        }

        return ServerResponse.createServerResponseBySuccess("修改成功");
    }

    @Override
    public ServerResponse update_information(User user) {

        if (user == null) {
            ServerResponse.createServerResponseByFail(Const.USER_UPDATE_PARAM_EMPTY, "参数不能为空");
        }

        int result = userMapper.updateUserByActivate(user);
        if (result <= 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_UPDATE_FAIL, "修改失败");
        }
        return ServerResponse.createServerResponseBySuccess("修改成功");
    }

    @Override
    public ServerResponse adminLogin(String username, String password, int type) {
        //参数非空校验
        if (username == null || username.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_USERNAME_EMPTY, "用户名为空");
        }
        if (password == null || password.equals("")) {
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_PASSWORD_EMPTY, "密码为空");
        }
        //检查用户名是否存在
        int checkUsernameExist = userMapper.checkUsernameExist(username);
        if (checkUsernameExist <= 0) {
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_USERNAME_NOT_EXIST, "用户名不存在");
        }

        //根据用户名密码查找信息
        password = MD5Utils.getMD5Code(password);
        User checkLoginResult = userMapper.checkByUsernameAndPassword(username, password);


        if (type == 0) {//管理员
            if (checkLoginResult.getRole() != UserRoleEnum.ROLE_ADMIN.getRole()) {//没有管理权限
                return ServerResponse.createServerResponseByFail(Const.USER_ADMIN_NORES, "登录权限不足");
            }
        } else {
            return ServerResponse.createServerResponseByFail(Const.USER_ADMIN_NORES, "登录权限不足");
        }

        if (checkLoginResult == null) {

            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_LOGIN_FAIL, "登录失败");
        }
        //返回结果
        return ServerResponse.createServerResponseBySuccess("登录成功", checkLoginResult);

    }


}
