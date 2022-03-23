package com.ldg.service.Impl;

import com.ldg.dao.ProductSpecsDao;
import com.ldg.entity.ProductSpecs;
import com.ldg.entity.Specs;
import com.ldg.service.ProductSpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class ProductSpecsServiceImpl implements ProductSpecsService {

    @Autowired
    private ProductSpecsDao productSpecsDao;

    @Override
    public List<ProductSpecs> selectAll() {
        return productSpecsDao.selectAll();
    }

    @Override
    public List<String> selectAllByProId(Integer productId) {
        return productSpecsDao.selectAllByProId(productId);
    }

    @Override
    public Boolean insertData(ProductSpecs productSpecs) {
        return productSpecsDao.insertData(productSpecs);
    }

    @Override
    public Boolean updateById(ProductSpecs productSpecs) {
        return productSpecsDao.updateById(productSpecs);
    }

    @Override
    public Boolean deleteById(ProductSpecs productSpecs) {
        return productSpecsDao.deleteById(productSpecs);
    }

    @Override
    public Boolean insertBatch(List<ProductSpecs> productSpecsList) {
        return productSpecsDao.insertBatch(productSpecsList);
    }

    @Override
    public Boolean deleteBatch(List<ProductSpecs> productSpecsList) {
        return productSpecsDao.deleteBatch(productSpecsList);
    }

    @Override
    public List<Specs> selectTAndSByPId(Integer productId) {
        return productSpecsDao.selectTAndSByPId(productId);
    }

    @Override
    public List<String> selectTypeName() {
        return productSpecsDao.selectTypeName();
    }
}
