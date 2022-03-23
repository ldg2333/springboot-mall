package com.ldg.dao;

import com.ldg.entity.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDao extends BaseDao<Brand>{
    /*查询所有品牌名*/
    List<String> selectAllName();

    //查询所有
    List<Brand> selectAllByName(@Param("brandName")String brandName);
    //通过品牌名删除
    Boolean deleteByName(@Param("typeName") String typeName);
    //判断商品类别是否存在
    Boolean existsWithBrandName(@Param("brandId")Integer brandId,@Param("brandName") String brandName);
}
