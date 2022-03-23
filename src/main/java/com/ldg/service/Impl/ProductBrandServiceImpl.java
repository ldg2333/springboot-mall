package com.ldg.service.Impl;
import com.ldg.dao.BrandDao;
import com.ldg.entity.Brand;
import com.ldg.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductBrandServiceImpl implements BrandService {

    @Autowired
    private  BrandDao brandDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Brand selectById(Integer brandId) {
        return brandDao.selectById(brandId);
    }

    @Override
    public List<Brand> selectAll() {
        return brandDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Brand> selectAllByName(String brandName) {
        return brandDao.selectAllByName(brandName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<String> selectAllName() {
        return brandDao.selectAllName();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Boolean existsWithBrandName(Integer brandId, String brandName) {
        return brandDao.existsWithBrandName(brandId,brandName);
    }

    @Override
    public Boolean insertData(Brand brand) {
        return brandDao.insertData(brand);
    }

    @Override
    public Boolean updateById(Brand brand) {
        return brandDao.updateById(brand);
    }

    @Override
    public Boolean deleteById(Integer brandId) {
        return brandDao.deleteById(brandId);
    }

    @Override
    public Boolean deleteByName(String brandName) {
        return brandDao.deleteByName(brandName);
    }
}
