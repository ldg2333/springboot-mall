package com.ldg.service;

import com.ldg.entity.AdminRole;
import com.ldg.entity.Role;

import java.util.List;
import java.util.Map;

public interface AdminRoleService {//通过id查询
    List<AdminRole> selectByAdminId(Integer adminId);
    //查询所有
    List<AdminRole> selectAll();
    //插入一条数据
    Boolean insertData(AdminRole adminRole);
    //通过ID删除
    Boolean deleteById(Integer adminId);
    //通过用户id查询角色信息
    List<Map<String,Object>> selectRoleByAdminId(Integer adminId);
    //判断角色是否存在
    Boolean existsRole(Integer roleId);

    //通过List删除
    Boolean deleteByList(List<AdminRole> list);
    //通过List添加
    Boolean addByList(List<AdminRole> list);
}
