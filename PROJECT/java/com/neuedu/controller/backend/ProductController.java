package com.neuedu.controller.backend;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-21 14:48
 **/

@RestController
@RequestMapping("/manage/product/")
public class ProductController {

    @Autowired
    IProductService productService;

    @RequestMapping("save.do")
    public ServerResponse addProduct(Product product){

        return productService.insertOrUpdateProduct(product);
    }

    @RequestMapping("/search.do")
    public  ServerResponse search(@RequestParam(name = "productName",required = false) String productName,
                                                            @RequestParam(name = "productId",required = false) Integer productId,
                                                            @RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                                            @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize){
        return productService.search(productName,productId,pageNum,pageSize);
    }

}
