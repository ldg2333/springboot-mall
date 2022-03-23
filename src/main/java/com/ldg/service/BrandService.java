package com.ldg.service;

import com.ldg.entity.Brand;

import java.util.List;

public interface BrandService {
    //通过ID查询
    Brand selectById(Integer brandId);
    //查询所有
    List<Brand> selectAll();
    //查询所有
    List<Brand> selectAllByName(String brandName);
    //查询所有分类名
    List<String> selectAllName();
    //判断商品类别是否存在
    Boolean existsWithBrandName(Integer brandId, String brandName);
    //插入一条数据
    Boolean insertData(Brand brand);
    //通过ID更新
    Boolean updateById(Brand brand);
    //通过ID删除
    Boolean deleteById(Integer brandId);
    //通过分类名删除
    Boolean deleteByName(String brandName);
}
