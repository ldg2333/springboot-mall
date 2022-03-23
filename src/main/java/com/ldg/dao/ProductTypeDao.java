package com.ldg.dao;

import com.ldg.entity.ProductType;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeDao extends BaseDao<ProductType> {
    /*查询所有分类名*/
    List<String> selectAllName();
    //通过分类名删除
    Boolean deleteByName(String typeName);
    //判断商品类别是否存在
    Boolean existsWithTypeName(@Param("typeId") Integer typeId, @Param("typeName") String typeName);
    //查询所有
    List<ProductType> selectAllByName(@Param("typeName")String typeName);

    Boolean isExistProduct(String productType);
}
