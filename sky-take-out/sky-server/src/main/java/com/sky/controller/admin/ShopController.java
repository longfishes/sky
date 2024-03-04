package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    /**
     * 设置店铺营业状态
     *
     * @param status 状态
     * @return res
     */
    @PutMapping("/{status}")
    @ApiOperation("设置店铺营业状态")
    public Result<String> setStatus(@PathVariable Integer status) {
        log.info("设置店铺状态为：{}", status.equals(1) ? "营业中" : "打样中");
        redisTemplate.opsForValue().set(KEY, status);

        return Result.success();
    }

    /**
     * 获取店铺营业状态
     *
     * @return status
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺营业状态")
    public Result<Integer> getStatus() {
        Integer status = redisTemplate.opsForValue().get(KEY);
        if (status == null) return Result.error(MessageConstant.UNKNOWN_ERROR);

        log.info("获取店铺的营业状态为：{}", status.equals(1) ? "营业中" : "打样中");
        return Result.success(status);
    }
}
