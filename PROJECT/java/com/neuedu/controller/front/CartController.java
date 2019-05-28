package com.neuedu.controller.front;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;
import com.neuedu.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-27 16:26
 **/

@RestController
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    ICartService cartService;

    @RequestMapping("add/{productId}/{count}")
    public ServerResponse addCart(@PathVariable("productId") Integer productId,
                                  @PathVariable("count") Integer count,
                                  HttpSession session){

        User user = (User) session.getAttribute("userLogin");
        if (user == null){
            return ServerResponse.createServerResponseByFail(Const.USER_lOGIN_NOT_LOGIN,"未登录");
        }
        return cartService.addProductToCart(user.getId(),productId,count);
    }
}
