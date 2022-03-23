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
public class ProductType implements Serializable {
    private int typeId; // 类别id
    private String typeName; // 类别名称
    private String typeDescribe; // 类别描述
    private String typeUrlLeft; // 左侧宣传图
    private String typeUrlTop; // 顶部宣传图

}
