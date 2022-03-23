package com.ldg.dao;

import com.ldg.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao extends BaseDao<User>{

    // 根据 id 查找用户
    User findUserByNumber(String accountNumber);

    // 登录商城
    User loginMall(User user);
    // 获取用户信息
    Map<String,Object> userInfo();

    List<User> selectAllUserByCon(@Param("key") String key);

}
