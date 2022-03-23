package com.ldg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private Integer orderId; // 订单id
    private String orderNo; // 订单编号
    private Date orderCreateTime;// 创建订单的时间
    private Date orderPayTime; // 支付时间
    private String productNo; // 商品编号
    private String productSpecs; // 商品类别
    private Integer userId; // 用户id
    private Double payPrice;// 支付金额
    private Integer payAmount;// 支付数量
    private Integer orderState;// 订单状态 0:未支付 1:已支付 2:已发货 3:交易成功 4:正在退货 5:退货成功
    private String orderUrl; // 订单图片
    private String provinceName; // 收货地址-省
    private String cityName; // 收货地址-市
    private String areaName; // 收货地址-区
    private String addressDetail; // 收货地址-详细地址
    private String name; // 收货人姓名
    private String phone;// 收货人手机
    private String zipCode;// 收货邮编
    private Double totalPrice; // 总价
    private String productName; //商品名称
    private String productType; //商品分类
    private String productDescribe;     //商品描述
    private String productBrand;    //商品品牌
    private Double inPrice;     //商品进价
    private Integer productId;     //商品进价
    private String returnReason;     //退款原因

}
