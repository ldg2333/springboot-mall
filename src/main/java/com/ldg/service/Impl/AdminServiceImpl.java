package com.ldg.service.Impl;

import com.ldg.dao.AdminDao;
import com.ldg.dao.UserDao;
import com.ldg.entity.Admin;
import com.ldg.entity.User;
import com.ldg.service.AdminService;
import com.ldg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public Admin findAdminByNumber(String adminNumber) {
        return adminDao.findAdminByNumber(adminNumber);
    }

    @Override
    public Admin selectById(Integer id) {
        return adminDao.selectById(id);
    }

    @Override
    public Admin selectByPhone(String telephone) {
        return adminDao.selectByPhone(telephone);
    }

    @Override
    public List<Admin> selectAll() {
        return adminDao.selectAll();
    }

    @Override
    public Integer selectCount() {
        return adminDao.selectCount();
    }

    @Override
    public Boolean selectAdminState(String accountNumber) {
        return adminDao.selectAdminState(accountNumber);
    }

    @Override
    public Boolean existsWithPrimaryKey(String existAdmin) {
        return adminDao.existsWithPrimaryKey(existAdmin);
    }

    @Override
    public Boolean existsWithPrimaryPhone(String telephone) {
        return existsWithPrimaryPhone(telephone);
    }


    @Override
    public Boolean insertData(Admin admin) {
        return adminDao.insertData(admin);
    }

    @Override
    public Boolean updateById(Admin admin) {
        return adminDao.updateById(admin);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return adminDao.deleteById(id);
    }

    @Override
    public List<com.ldg.entity.Admin> selectAllByKey(String key) {
        return adminDao.selectAllByKey(key);
    }
}
