package com.neuedu.controller.backend;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.soap.SAAJResult;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-14 14:38
 **/

@RestController
@RequestMapping("/manage/category/")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @RequestMapping("add_category")
    public ServerResponse addCategory(Category category) {
        return iCategoryService.addCategory(category);
    }

    @RequestMapping("set_category")
    public ServerResponse setCategory(Category category) {
        return iCategoryService.setCategory(category);
    }

    @RequestMapping("{categoryId}")
    public ServerResponse getCategoryById(@PathVariable("categoryId") Integer categoryId) {
        return iCategoryService.getCategoryById(categoryId);
    }

    @RequestMapping("deep/{categoryId}")
    public ServerResponse deepCategory(@PathVariable("categoryId") Integer categoryId) {
        return iCategoryService.deepCategory(categoryId);
    }
}
