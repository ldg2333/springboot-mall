package com.ldg.dao;

import com.ldg.entity.Admin;
import com.ldg.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao extends BaseDao<Admin>{

    // 根据 id 查找管理员
    Admin findAdminByNumber(String adminNumber);
    //查询用户状态
    Boolean selectAdminState(String adminNumber);
    //通过手机号查询管理员
    Admin selectByPhone(String telephone);

    List<Admin> selectAllByKey(@Param("key") String key);

}
