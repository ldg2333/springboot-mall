package com.ldg.dao;

import com.ldg.entity.ShopCart;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShopCartDao extends BaseDao<ShopCart>{

    // 查询当前用户购物车的所有内容
    List<Map<String,Object>> selectAll(Integer userId);

    // 查询当前用户购物车数量
    int selectAmount(Integer userId);

    // 根据用户id删除购物车内容
    Boolean deleteByUserId(Integer userId);

    // 判断当前商品规格是否存在购物车中
    ShopCart existProductSpecs(ShopCart shopCart);

}
