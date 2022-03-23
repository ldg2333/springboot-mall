package com.ldg.service;

import com.ldg.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    //通过ID查询
    ProductType selectById(Integer typeId);
    //查询所有
    List<ProductType> selectAllByName(String typeName);
    //查询所有
    List<ProductType> selectAll();
    //判断商品类别是否存在
    Boolean existsWithTypeName(Integer typeId, String typeName);
    //查询所有分类名
    List<String> selectAllName();
    //插入一条数据
    Boolean insertData(ProductType productType);
    //通过ID更新
    Boolean updateById(ProductType productType);
    //通过ID删除
    Boolean deleteById(Integer typeId);
    //通过分类名删除
    Boolean deleteByName(String typeName);

    Boolean isExistProduct(String productType);
}
