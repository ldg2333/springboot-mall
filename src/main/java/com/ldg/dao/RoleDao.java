package com.ldg.dao;
import com.ldg.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao extends BaseDao<Role> {
    //查询所有可用的
    List<Role> selectAllUsable();
    List<Role> selectAllByName(@Param("roleName")String roleName);
    //判断角色名称是否存在
    Boolean existsRoleName(@Param("roleId") Integer roleId, @Param("roleName") String roleName);
}
