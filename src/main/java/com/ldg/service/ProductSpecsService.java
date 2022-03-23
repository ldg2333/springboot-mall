package com.ldg.service;

import com.ldg.entity.ProductSpecs;
import com.ldg.entity.Specs;

import java.util.List;
import java.util.Map;

public interface ProductSpecsService {
    //查询所有
    List<ProductSpecs> selectAll();

    //根据商品id查询所有商品规格名称
    List<String> selectAllByProId(Integer productId);

    //插入一条数据
    Boolean insertData(ProductSpecs productSpecs);

    //通过ID更新
    Boolean updateById(ProductSpecs productSpecs);

    //通过ID删除
    Boolean deleteById(ProductSpecs productSpecs);

    //批量添加
    Boolean insertBatch(List<ProductSpecs> productSpecsList);

    // 批量新增
    Boolean deleteBatch(List<ProductSpecs> productSpecsList);

    // 查询回显数据
    List<Specs> selectTAndSByPId(Integer productId);

    List<String> selectTypeName();
}
