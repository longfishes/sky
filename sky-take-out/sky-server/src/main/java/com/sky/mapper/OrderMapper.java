package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 新增订单
     *
     * @param orders orders
     */
    void insert(Orders orders);

    /**
     * 根据订单状态和下单时间查询订单
     *
     * @param status    status
     * @param orderTime time
     * @return list
     */
    @Select("select * from sky_take_out.orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrderTimeLT(Integer status, LocalDateTime orderTime);

    /**
     * 根据订单号查询订单
     *
     * @param orderNumber orderNum
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     *
     * @param orders orders
     */
    void update(Orders orders);
}
