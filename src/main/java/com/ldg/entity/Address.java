package com.ldg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address implements Serializable {
    private Integer addressId; // 收货id
    private Integer userId; // 归属的用户id
    private String name; // 收货人姓名
    private String provinceName; // 省-名称
    private String cityName; // 市-名称
    private String areaName; // 区-名称
    private String addressDetail; // 详细地址
    private String zipCode; // 邮政编码
    private String phone; // 手机
    private Integer isDefault; // 是否默认：0-不默认，1-默认

    public Address(Integer addressId, Integer isDefault,Integer userId) {
        this.addressId = addressId;
        this.isDefault = isDefault;
        this.userId = userId;
    }
}








