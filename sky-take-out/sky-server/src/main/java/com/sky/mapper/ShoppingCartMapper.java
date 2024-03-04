package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 动态条件查询
     *
     * @param shoppingCart entity
     * @return list
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 根据id修改数量
     *
     * @param shoppingCart entity
     */
    @Update("update sky_take_out.shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     * 插入购物车数据
     *
     * @param shoppingCart entity
     */
    void insert(ShoppingCart shoppingCart);

    /**
     * 根据用户删除
     *
     * @param userId user id
     */
    @Delete("delete from sky_take_out.shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long userId);

    /**
     * 根据id删除购物车数据
     *
     * @param id id
     */
    @Delete("delete from shopping_cart where id = #{id}")
    void deleteById(Long id);
}
