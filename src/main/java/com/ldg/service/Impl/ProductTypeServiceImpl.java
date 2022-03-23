package com.ldg.service.Impl;

import com.ldg.dao.ProductTypeDao;
import com.ldg.entity.ProductType;
import com.ldg.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public ProductType selectById(Integer typeId) {
        return productTypeDao.selectById(typeId);
    }

    @Override
    public List<ProductType> selectAllByName(String typeName) {
        return productTypeDao.selectAllByName(typeName);
    }

    @Override
    public List<ProductType> selectAll() {
        return productTypeDao.selectAll();
    }

    @Override
    public Boolean existsWithTypeName(Integer typeId, String typeName) {
        return productTypeDao.existsWithTypeName(typeId,typeName);
    }

    @Override
    public List<String> selectAllName() {
        return productTypeDao.selectAllName();
    }

    @Override
    public Boolean insertData(ProductType productType) {
        return productTypeDao.insertData(productType);
    }

    @Override
    public Boolean updateById(ProductType productType) {
        return productTypeDao.updateById(productType);
    }

    @Override
    public Boolean deleteById(Integer typeId) {
        return productTypeDao.deleteById(typeId);
    }

    @Override
    public Boolean deleteByName(String typeName) {
        return productTypeDao.deleteByName(typeName);
    }

    @Override
    public Boolean isExistProduct(String productType) {
        return productTypeDao.isExistProduct(productType);
    }
}
