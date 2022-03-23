package com.ldg.dao;

import com.ldg.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductDao extends BaseDao<Product> {
    //根据商品分类查询
    List<Map<String,Object>> selectAllByType();
    //根据商品名称模糊查询
    List<Product> selectAllLikeName(String keyWord);
    //根据商品类型模糊查询
    List<Product> selectAllLikeType(String keyWord);
    //根据商品品牌模糊查询
    List<Product> selectAllLikeBrand(String keyWord);
    List<Product> selectAllLikeKeyWord(@Param("keyWord") String keyWord);
    //查询所有上架商品，并按开售时间排序
    List<Product> selectAllSale();
    //查询所有新品
    List<Product> selectAllNew();
    //判断商品类别是否存在
    Boolean existsProductType(String productType);
    //判断商品类别是否存在
    Boolean existsProductBrand(String productBrand);
    //查询商品数量、商品上架数量
    Map<String,Object> productOverview();
    // 根据编号更改库存
    Boolean updateByNo(@Param("productNo")String productNo, @Param("productStock")Integer productStock,@Param("saleStock")Integer saleStock);
    // 商品信息
    Map<String,Object> productInfo();
    // 根据条件查询
    List<Product> selectAllByCondition(Map map);
    // 根据条件查询记录
    Integer getProductCountByCon(Map map);
    // 批量更新上下架
    Boolean updateIsSale(@Param("isSale")Integer isSale,@Param("isNew")Integer isNew,@Param("ids")List<Integer> ids);

}
