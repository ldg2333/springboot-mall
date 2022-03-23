package com.ldg.service;

import com.ldg.entity.Admin;
import com.ldg.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {

    // 根据 id 查找用户
    Admin findAdminByNumber(String adminNumber);
    //通过ID查询
    Admin selectById(Integer id);
    //通过手机号查询
    Admin selectByPhone(String telephone);
    //查询所有
    List<Admin> selectAll();
    //查询记录个数
    Integer selectCount();
    //查询用户状态
    Boolean selectAdminState(String accountNumber);
    //判断帐号是否存在
    Boolean existsWithPrimaryKey(String existAdmin);
    //判断手机号telephone是否存在
    Boolean existsWithPrimaryPhone(String telephone);
    //插入一条数据
    Boolean insertData(Admin Admin);
    //通过ID更新
    Boolean updateById(Admin Admin);
    //通过ID删除
    Boolean deleteById(Integer id);

    List<Admin> selectAllByKey(String key);
}
