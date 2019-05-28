package com.neuedu.service.impl;

import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Product;
import com.neuedu.service.ICartService;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-27 16:44
 **/

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    IProductService productService;

    @Override
    public ServerResponse addProductToCart(Integer userId, Integer productId, Integer count) {

        if (productId == null) {
            return ServerResponse.createServerResponseByFail(Const.CART_ADD_PRODUCTID_EMPTY, "商品id必传");
        }
        if (count == null) {
            return ServerResponse.createServerResponseByFail(Const.CART_ADD_COUNT_EMPTY, "商品数量不能为0");
        }
        ServerResponse<Product> serverResponse = productService.findProductById(productId);
        if (!serverResponse.isSuccess()) {
            return ServerResponse.createServerResponseByFail(serverResponse.getStatus(), serverResponse.getMsg());
        } else {
            Product product = serverResponse.getData();
            if (product.getStock()<=0){
                return ServerResponse.createServerResponseByFail(Const.CART_STOCK_EMPTY,"库存为空");
            }
            return ServerResponse.createServerResponseBySuccess();
        }
    }
}
