package com.ldg.service.Impl;

import com.ldg.dao.RoleDao;
import com.ldg.entity.Role;
import com.ldg.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role selectById(Integer id) {
        return roleDao.selectById(id);
    }

    @Override
    public Role selectByKey(String key) {
        return roleDao.selectByKey(key);
    }

    @Override
    public List<Role> selectAll() {
        return roleDao.selectAll();
    }

    @Override
    public List<Role> selectAllUsable() {
        return roleDao.selectAllUsable();
    }

    @Override
    public Boolean existsRoleName(Integer roleId, String roleName) {
        return roleDao.existsRoleName(roleId,roleName);
    }

    @Override
    public Integer selectCount() {
        return roleDao.selectCount();
    }

    @Override
    public Integer selectIdByKey(String key) {
        return roleDao.selectIdByKey(key);
    }

    @Override
    public Boolean insertData(Role role) {
        return roleDao.insertData(role);
    }

    @Override
    public Boolean updateById(Role role) {
        return roleDao.updateById(role);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return roleDao.deleteById(id);
    }

    @Override
    public List<Role> selectAllByName(String roleName) {
        return roleDao.selectAllByName(roleName);
    }

}
