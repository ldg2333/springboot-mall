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
// 商品与商品规格映射表
public class ProductSpecs  implements Serializable {
    private Integer productId; // 商品id
    private Integer specsId; // 规格id


}
