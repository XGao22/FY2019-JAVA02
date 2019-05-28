package com.neuedu.service;

import com.neuedu.common.ServerResponse;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-27 16:28
 **/
public interface ICartService {

    public ServerResponse addProductToCart(Integer userId, Integer productId, Integer count);
}
