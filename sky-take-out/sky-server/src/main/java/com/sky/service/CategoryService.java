package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {

    /**
     * 新增分类
     *
     * @param categoryDTO dto
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 分页查询
     *
     * @param categoryPageQueryDTO dto
     * @return page bean
     */
    PageResult<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据id删除分类
     *
     * @param id id
     */
    void deleteById(Long id);

    /**
     * 修改分类
     *
     * @param categoryDTO dto
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 启用、禁用分类
     *
     * @param status 状态
     * @param id     id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据类型查询分类
     *
     * @param type 类型
     * @return categories
     */
    List<Category> list(Integer type);
}
