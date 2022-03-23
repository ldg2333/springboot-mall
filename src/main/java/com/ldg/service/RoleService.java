package com.ldg.service;

import com.ldg.entity.Role;

import java.util.List;


public interface RoleService {
    //通过ID查询
    Role selectById(Integer id);
    //通过ID查询
    Role selectByKey(String key);
    //查询所有
    List<Role> selectAll();
    //查询所有可用的
    List<Role> selectAllUsable();
    //判断角色名称是否存在
    Boolean existsRoleName(Integer roleId, String roleName);
    //查询记录个数
    Integer selectCount();
    //通过Key查Id
    Integer selectIdByKey(String key);
    //插入一条数据
    Boolean insertData(Role role);
    //通过ID更新
    Boolean updateById(Role role);
    //通过ID删除
    Boolean deleteById(Integer id);

    List<Role> selectAllByName(String roleName);

}
