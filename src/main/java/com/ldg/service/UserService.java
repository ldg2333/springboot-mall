package com.ldg.service;

import com.ldg.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    // 根据 id 查找用户
    User findUserByNumber(String accountNumber);

    //插入一条数据
    Boolean insertData(User user);

    //通过ID更新
    Boolean updateById(User user);

    // 登录商城
    User loginMall(User user);
    // 获取用户信息
    Map<String,Object> userInfo();

    List<User> selectAllUserByCon(String key);
}
