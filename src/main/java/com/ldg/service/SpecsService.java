package com.ldg.service;

import com.ldg.entity.Specs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecsService {
    //通过ID查询
    Specs selectById(Integer specsId);
    //查询所有
    List<Specs> selectAll();

    List<Specs> selectAllByNAT(String key);

    //根据类型查询所有
    List<Specs> selectAllByType(String productType);
    //插入一条数据
    Boolean insertData(Specs specs);
    //通过ID更新
    Boolean updateById(Specs specs);
    //通过ID删除
    Boolean deleteById(Integer specsId);
    //判断商品规格是否存在
    Boolean existsWithSpecsName(Integer specsId, String specsName, String productType);

    Boolean existsWithName(String specsName,String productType);

    Boolean isExistProduct(Integer specsId,String productType);
}
