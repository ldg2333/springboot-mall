package com.ldg.dao;
import com.ldg.entity.Specs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecsDao extends BaseDao<Specs> {
    //根据类型查询所有
    List<Specs> selectAllByType(String productType);

    List<Specs> selectAllByNAT(String key);

    //判断商品规格是否存在
    Boolean existsWithSpecsName(@Param("specsId") Integer specsId, @Param("specsName") String specsName, @Param("productType") String productType);

    Boolean existsWithName(@Param("specsName") String specsName,@Param("productType") String productType);

    Boolean isExistProduct(@Param("specsId") Integer specsId,@Param("productType") String productType);
}
