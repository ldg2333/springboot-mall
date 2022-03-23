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
public class Specs implements Serializable {
    private Integer specsId; // 规格id
    private String specsName; // 规格名称
    private String productType; // 商品类别
}
