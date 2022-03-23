package com.ldg.service.Impl;

import com.ldg.dao.BannerDao;
import com.ldg.entity.Banner;
import com.ldg.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public Banner selectById(Integer bannerId) {
        return bannerDao.selectById(bannerId);
    }

    @Override
    public List<Banner> selectAll() {
        return bannerDao.selectAll();
    }

    @Override
    public Boolean insertData(Banner banner) {
        return bannerDao.insertData(banner);
    }

    @Override
    public Boolean updateById(Banner banner) {
        return bannerDao.updateById(banner);
    }

    @Override
    public Boolean deleteById(Integer bannerId) {
        return bannerDao.deleteById(bannerId);
    }

    @Override
    public List<Banner> selectAllByName(String bannerName) {
        return bannerDao.selectAllByName(bannerName);
    }

}
