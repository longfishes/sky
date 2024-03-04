package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {

    /**
     * 新增菜品和对应的口味
     *
     * @param dishDTO dto
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO dto
     * @return page bean
     */
    PageResult<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量删除
     *
     * @param ids list
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询菜品和对应的口味数据
     *
     * @param id id
     * @return vo
     */
    DishVO getByIdWithDishFlavor(Long id);

    /**
     * 根据id修改菜品基本信息和对应的口味信息
     *
     * @param dishDTO dto
     */
    void updateWithFlavor(DishDTO dishDTO);

    /**
     * 菜品起售停售
     *
     * @param status status
     * @param id     id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据分类id查询菜品
     *
     * @param categoryId id
     * @return list
     */
    List<Dish> list(Long categoryId);

    /**
     * 条件查询菜品和口味
     *
     * @param dish dish
     * @return vo
     */
    List<DishVO> listWithFlavor(Dish dish);
}
