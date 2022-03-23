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
public class Brand implements Serializable {
    private Integer brandId; // 品牌id
    private String brandName; // 品牌名称
    private String brandDescribe; // 品牌描述
}
