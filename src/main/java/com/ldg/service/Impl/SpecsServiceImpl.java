package com.ldg.service.Impl;

import com.ldg.dao.SpecsDao;
import com.ldg.entity.Specs;
import com.ldg.service.SpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecsServiceImpl implements SpecsService {
    @Autowired
    private SpecsDao specsDao;

    @Override
    public Specs selectById(Integer specsId) {
        return specsDao.selectById(specsId);
    }

    @Override
    public List<Specs> selectAll() {
        return specsDao.selectAll();
    }

    @Override
    public List<Specs> selectAllByNAT(String key) {
        return specsDao.selectAllByNAT(key);
    }

    @Override
    public List<Specs> selectAllByType(String productType) {
        return specsDao.selectAllByType(productType);
    }

    @Override
    public Boolean insertData(Specs specs) {
        return specsDao.insertData(specs);
    }

    @Override
    public Boolean updateById(Specs specs) {
        return specsDao.updateById(specs);
    }

    @Override
    public Boolean deleteById(Integer specsId) {
        return specsDao.deleteById(specsId);
    }

    @Override
    public Boolean existsWithSpecsName(Integer specsId, String specsName, String productType) {
        return specsDao.existsWithSpecsName(specsId,specsName,productType);
    }

    @Override
    public Boolean existsWithName(String specsName, String productType) {
        return specsDao.existsWithName(specsName, productType);
    }

    @Override
    public Boolean isExistProduct(Integer specsId, String productType) {
        return specsDao.isExistProduct(specsId, productType);
    }
}
