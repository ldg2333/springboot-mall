package com.ldg.service.Impl;

import com.ldg.dao.ShopCartDao;
import com.ldg.entity.ShopCart;
import com.ldg.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartDao shopCartDao;

    @Override
    public ShopCart selectById(Integer cartId) {
        return shopCartDao.selectById(cartId);
    }

    @Override
    public List<Map<String, Object>> selectAll(Integer userId) {
        return shopCartDao.selectAll(userId);
    }

    @Override
    public Boolean insertData(ShopCart shopCart) {
        return shopCartDao.insertData(shopCart);
    }

    @Override
    public int selectAmount(Integer userId) {
        return shopCartDao.selectAmount(userId);
    }

    @Override
    public Boolean updateById(ShopCart shopCart) {
        return shopCartDao.updateById(shopCart);
    }

    @Override
    public Boolean deleteById(Integer cartId) {
        return shopCartDao.deleteById(cartId);
    }

    @Override
    public Boolean deleteByUserId(Integer userId) {
        return shopCartDao.deleteByUserId(userId);
    }

    @Override
    public ShopCart existProductSpecs(ShopCart shopCart) {
        return shopCartDao.existProductSpecs(shopCart);
    }
}
