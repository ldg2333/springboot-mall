package com.ldg.service.Impl;

import com.ldg.dao.UserDao;
import com.ldg.entity.User;
import com.ldg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByNumber(String accountNumber) {
        return userDao.findUserByNumber(accountNumber);
    }

    @Override
    public Boolean insertData(User user) {
        return userDao.insertData(user);
    }

    @Override
    public Boolean updateById(User user) {
        return userDao.updateById(user);
    }

    @Override
    public User loginMall(User user) {
        return userDao.loginMall(user);
    }

    @Override
    public Map<String, Object> userInfo() {
        return userDao.userInfo();
    }

    @Override
    public List<User> selectAllUserByCon(String key) {
        return userDao.selectAllUserByCon(key);
    }


}
