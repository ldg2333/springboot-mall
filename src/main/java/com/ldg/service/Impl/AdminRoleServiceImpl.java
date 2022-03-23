package com.ldg.service.Impl;

import com.ldg.dao.AdminRoleDao;
import com.ldg.entity.AdminRole;
import com.ldg.entity.Role;
import com.ldg.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Override
    public List<AdminRole> selectByAdminId(Integer adminId) {
        return adminRoleDao.selectByAdminId(adminId);
    }

    @Override

    public List<AdminRole> selectAll() {
        return adminRoleDao.selectAll();
    }

    @Override
    public Boolean insertData(AdminRole adminRole) {
        return adminRoleDao.insertData(adminRole);
    }

    @Override
    public Boolean deleteById(Integer adminId) {
        return adminRoleDao.deleteById(adminId);
    }

    @Override
    public List<Map<String, Object>> selectRoleByAdminId(Integer adminId) {
        return adminRoleDao.selectRoleByAdminId(adminId);
    }

    @Override
    public Boolean existsRole(Integer roleId) {
        return adminRoleDao.existsRole(roleId);
    }

    @Override
    public Boolean deleteByList(List<AdminRole> list) {
        return adminRoleDao.deleteByList(list);
    }

    @Override
    public Boolean addByList(List<AdminRole> list) {
        return adminRoleDao.addByList(list);
    }

}
