package com.ldg.config;

import com.ldg.entity.Admin;
import com.ldg.entity.AdminRole;
import com.ldg.entity.Role;
import com.ldg.service.AdminRoleService;
import com.ldg.service.AdminService;
import com.ldg.service.RoleService;
import com.ldg.service.UserService;
import com.ldg.utils.MyByteSource;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

// 自定义类 UserRealm
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了admin授权=》授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到 admin 对象
        Admin admin = (Admin)principalCollection.getPrimaryPrincipal();
        List<AdminRole> adminRoles = adminRoleService.selectByAdminId(admin.getAdminId());
        AdminRole adminRole;
        for (AdminRole value : adminRoles) {
            adminRole = value;//得到角色列表
            if (adminRole != null) {
                Role role = roleService.selectById(adminRole.getRoleId()); //获得角色
                info.addRole(role.getRoleName()); //添加 角色
            }
        }
        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了admin认证=》认证doGetAuthorizationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        // 连接真实的数据库
        Admin admin = adminService.findAdminByNumber(userToken.getUsername());
        if(admin == null){ // 用户不存在
            return null;
        }
        if(admin.getAdminState() == 0) {
            throw new LockedAccountException(); //帐号锁定
        }
        // 密码认证 shiro 做
        return new SimpleAuthenticationInfo(admin,admin.getPassword(), MyByteSource.Util.bytes(admin.getAdminNumber()),getName());
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
