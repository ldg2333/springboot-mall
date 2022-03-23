package com.ldg.service.Impl;

import com.ldg.dao.ProductDao;
import com.ldg.entity.Product;
import com.ldg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product selectById(Integer productId) {
        return productDao.selectById(productId);
    }

    @Override
    public Product selectByKey(String productNo) {
        return productDao.selectByKey(productNo);
    }

    @Override
    public Integer selectIdByKey(String productNo) {
        return productDao.selectIdByKey(productNo);
    }

    @Override
    public Integer selectCount() {
        return productDao.selectCount();
    }

    @Override
    public Boolean existsWithPrimaryKey(String productNo) {
        return productDao.existsWithPrimaryKey(productNo);
    }

    @Override
    public Boolean existsProductType(String productType) {
        return productDao.existsProductType(productType);
    }

    @Override
    public Boolean existsProductBrand(String productBrand) {
        return productDao.existsProductBrand(productBrand);
    }

    @Override
    public List<Product> selectAll() {
        return productDao.selectAll();
    }

    @Override
    public List<Product> selectAllNew() {
        return productDao.selectAllNew();
    }

    @Override
    public List<Product> selectAllSale() {
        return productDao.selectAllSale();
    }

    @Override
    public List<Map<String,Object>> selectAllByType() {
        return productDao.selectAllByType();
    }

    @Override
    public Boolean insertData(Product product) {
        product.setSaleTime(new Date());
        return productDao.insertData(product);
    }

    @Override
    public Boolean updateById(Product product) {
        return productDao.updateById(product);
    }

    @Override
    public Boolean deleteById(Integer productId) {
        return productDao.deleteById(productId);
    }

    @Override
    public List<Product> selectAllLikeName(String keyWord) {
        return productDao.selectAllLikeName(keyWord);
    }

    @Override
    public List<Product> selectAllLikeType(String keyWord) {
        return productDao.selectAllLikeType(keyWord);
    }

    @Override
    public List<Product> selectAllLikeBrand(String keyWord) {
        return productDao.selectAllLikeBrand(keyWord);
    }

    @Override
    public Map<String, Object> productOverview() {
        return productDao.productOverview();
    }

    @Override
    public Boolean updateByNo(String productNo, Integer productStock,Integer saleStock) {
        return productDao.updateByNo(productNo, productStock, saleStock);
    }

    @Override
    public Map<String, Object> productInfo() {
        return productDao.productInfo();
    }

    @Override
    public List<Product> selectAllByCondition(Map map) {
        return productDao.selectAllByCondition(map);
    }

    @Override
    public Integer getProductCountByCon(Map map) {
        return productDao.getProductCountByCon(map);
    }

    @Override
    public Boolean updateIsSale(Integer isSale,Integer isNew, List<Integer> ids) {
        return productDao.updateIsSale(isSale, isNew,ids);
    }

    @Override
    public List<Product> selectAllLikeKeyWord(String keyWord) {
        return productDao.selectAllLikeKeyWord(keyWord);
    }
}
