package com.ldg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {
    private Integer productId;  //商品id
    private String productNo;   //商品编号
    private String productName; //商品名称
    private String productType; //商品分类
    private String productDescribe;     //商品描述
    private String productBrand;    //商品品牌
    private Double inPrice;     //商品进价
    private Double outPrice;    //商品售价
    private Integer productStock;   //商品库存
    private Integer isNew;  //是否新品 0:非新品 1:新品
    private Integer isSale; //是否上架 0:下架 1:上架
    private Date saleTime;  //上架时间
    private String productUrl;  //图片链接
    private Integer saleStock; // 商品销量

}
