package com.ldg.service;

import com.ldg.entity.ShopCart;

import java.util.List;
import java.util.Map;

public interface ShopCartService {
    //通过ID查询
    ShopCart selectById(Integer cartId);
    //查询所有
    List<Map<String,Object>> selectAll(Integer userId);
    //插入一条数据
    Boolean insertData(ShopCart shopCart);
    // 查询当前用户购物车数量
    int selectAmount(Integer userId);
    //通过ID更新
    Boolean updateById(ShopCart shopCart);
    //通过ID删除
    Boolean deleteById(Integer cartId);
    //通过账户删除
    Boolean deleteByUserId(Integer userId);

    // 判断当前商品规格是否存在购物车中
    ShopCart existProductSpecs(ShopCart shopCart);
}
