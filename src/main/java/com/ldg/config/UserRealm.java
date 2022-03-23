package com.ldg.config;

import com.ldg.entity.User;
import com.ldg.service.UserService;
import com.ldg.utils.MyByteSource;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了user授权=》授权doGetAuthorizationInfo");
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了user认证=》认证doGetAuthorizationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        // 连接真实的数据库
        User user = userService.findUserByNumber(userToken.getUsername());
        System.out.println(user);
        if(user == null){ // 用户不存在
            return null;
        }
        if(user.getUserState() == 0) {
            throw new LockedAccountException(); //帐号锁定
        }
        // 密码认证 shiro 做
        return new SimpleAuthenticationInfo(user,user.getPassword(), MyByteSource.Util.bytes(user.getAccountNumber()),getName());
    }
    /**
     * 清除当前用户的权限认证缓存
     * @param principals 权限信息 身份集合
     */
    @Override
    @Async
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }
}
