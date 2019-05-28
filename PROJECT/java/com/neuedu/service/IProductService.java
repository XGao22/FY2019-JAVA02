package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.ProductMapper;
import com.neuedu.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-24 08:13
 **/

public interface IProductService {

    public ServerResponse insertOrUpdateProduct(Product product);

    public ServerResponse search(String productName, Integer productId, Integer pageNum, Integer pageSize);

    public ServerResponse findProductById(Integer productId);
}
