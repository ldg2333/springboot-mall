package com.ldg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShopCart implements Serializable {
    private Integer cartId; // 购物车id
    private String userId; // 用户id
    private Integer productId; // 商品id
    private Integer payAmount; // 商品数量
    private String productSpecs; // 商品规格
}
