package com.neuedu.service.impl;

import com.google.common.collect.Sets;
import com.neuedu.common.Const;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.CategoryMapper;
import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @program: business
 * @description
 * @author: X.Gao
 * @create: 2019-05-14 14:51
 **/

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ServerResponse addCategory(Category category) {

        if (category == null) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_PARAM_EMPTY, "参数不能为空");
        }

        int result = categoryMapper.insert(category);
        if (result <= 0) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_ADD_FAIL, "添加品类失败");
        }
        return ServerResponse.createServerResponseBySuccess("添加成功");
    }

    @Override
    public ServerResponse setCategory(Category category) {

        if (category == null) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_PARAM_EMPTY, "参数不能为空");
        }
        if (category.getId() == null) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_PARAM_EMPTY, "类别id必传");
        }

        int result = categoryMapper.updateByPrimaryKey(category);
        if (result <= 0) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_SET_FAIL, "更新品类失败");
        }
        return ServerResponse.createServerResponseBySuccess("更新成功");
    }

    @Override
    public ServerResponse getCategoryById(Integer categoryId) {

        if (categoryId == null) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_PARAM_EMPTY, "类别id必传");
        }

        List<Category> categoryList = categoryMapper.selectCategoryById(categoryId);
        if (categoryList == null || categoryList.size() <= 0) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_SELECT_FAIL, "查询失败");
        }
        return ServerResponse.createServerResponseBySuccess("查询成功", categoryList);
    }

    @Override
    public ServerResponse deepCategory(Integer categoryId) {

        if (categoryId == null) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_PARAM_EMPTY, "类别id必传");
        }

        //初始化一个Set
        Set<Category> categorySet = Sets.newHashSet();
        //查询到的子节点集合
        Set<Category> resultCategorySet = findAllChild(categorySet, categoryId);
        //初始化一个integer集合
        Set<Integer> integerSet = Sets.newHashSet();

        if (resultCategorySet == null) {
            return ServerResponse.createServerResponseByFail(Const.CATEGORY_SELECT_FAIL, "查询失败");
        }
        //整合
        Iterator<Category> iterator = resultCategorySet.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            integerSet.add(category.getId());
        }
        return ServerResponse.createServerResponseBySuccess("查询成功", integerSet);
    }

    public Set<Category> findAllChild(Set<Category> categorySet, Integer categoryId) {

        //获取该节点
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category != null) {
            categorySet.add(category);
        }
        //获取所有子节点
        List<Category> resultList = categoryMapper.selectCategoryById(categoryId);

        //递归查询子节点
        if (resultList != null && resultList.size() > 0){
            for (Category category1:resultList){
                findAllChild(categorySet,category1.getId());
            }
        }
            return categorySet;
    }
}
