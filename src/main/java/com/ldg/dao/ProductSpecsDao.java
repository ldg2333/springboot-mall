package com.ldg.dao;

import com.ldg.entity.ProductSpecs;
import com.ldg.entity.Specs;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductSpecsDao extends BaseDao<ProductSpecs> {
    //根据商品id查询所有商品规格名称
    List<String> selectAllByProId(Integer productId);
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
