package com.neuedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.ProductMapper;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.vo.ProductListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-24 08:35
 **/

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ServerResponse insertOrUpdateProduct(Product product) {

        Integer productId = product.getId();

        if (productId == null) {
            int result = productMapper.insert(product);
            if (result <= 0) {
                return ServerResponse.createServerResponseByFail(Const.PRODUCT_ADD_FAIL, "添加商品失败");
            }
            return ServerResponse.createServerResponseBySuccess("添加成功");
        } else {
            int result = productMapper.updateByPrimaryKey(product);
            if (result <= 0) {
                return ServerResponse.createServerResponseByFail(Const.PRODUCT_UPDATE_FAIL, "更新商品失败");
            }
            return ServerResponse.createServerResponseBySuccess("更新成功");
        }
    }

    @Override
    public ServerResponse search(String productName, Integer productId, Integer pageNum, Integer pageSize) {

        if (productName != null) {
            productName = "%" + productName + "%";
        }

        Page page = PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.findProductByNameAndId(productName, productId);

        List<ProductListVO> productListVOList = new ArrayList();
        if (productList != null || productList.size() > 0) {
            for (Product product : productList) {
                ProductListVO productListVO = assembleProductListVO(product);
                productListVOList.add(productListVO);
            }
        }

        PageInfo pageInfo = new PageInfo(page);

        return ServerResponse.createServerResponseBySuccess("查询成功", pageInfo);
    }

    @Override
    public ServerResponse findProductById(Integer productId) {

        if (productId == null){
            return ServerResponse.createServerResponseByFail(Const.PARAM_EMPTY,"商品ID为空");
        }

        Product product = productMapper.findProductByPrimaryId(productId);
        if (product == null){
            return ServerResponse.createServerResponseByFail(Const.PRODUCT_NOT_EXIST,"商品不存在");
        }

        return ServerResponse.createServerResponseBySuccess("查询成功",product);
    }

    private ProductListVO assembleProductListVO(Product product) {
        ProductListVO productListVO = new ProductListVO();
        productListVO.setId(product.getId());
        productListVO.setCategoryId(product.getCategoryId());
        productListVO.setMainImage(product.getMainImage());
        productListVO.setName(product.getName());
        productListVO.setPrice(product.getPrice());
        productListVO.setStatus(product.getStatus());
        productListVO.setSubtitle(product.getSubtitle());


        return productListVO;
    }
}
