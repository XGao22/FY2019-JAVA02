package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Category;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-14 14:51
 **/
public interface ICategoryService {

    public ServerResponse addCategory(Category category);

    public ServerResponse setCategory(Category category);

    public ServerResponse getCategoryById(Integer categoryId);

    public ServerResponse deepCategory(Integer categoryId);
}
