package com.ldg.service.Impl;

import com.ldg.dao.AddressDao;
import com.ldg.entity.Address;
import com.ldg.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> selectAllByUserId(Integer userId) {
        return addressDao.selectAllByUserId(userId);
    }

    @Override
    public List<Address> selectAll() {
        return addressDao.selectAll();
    }

    @Override
    public Address selectById(Integer id) {
        return addressDao.selectById(id);
    }

    @Override
    public Boolean insertData(Address address) {
        return addressDao.insertData(address);
    }

    @Override
    public Boolean updateById(Address address) {
        return addressDao.updateById(address);
    }

    @Override
    public Boolean deleteById(Integer addressId) {
        return addressDao.deleteById(addressId);
    }

    @Override
    public Address existsDefaultAddress(Address address) {
        return addressDao.existsDefaultAddress(address);
    }
}
