package com.ldg.entity;

import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Banner implements Serializable {
    private Integer bannerId; // 轮播图 id
    private String productName; // 对应的商品名称
    private String productUrl; // 商品链接
    private String bannerUrl; // 轮播图链接
}
