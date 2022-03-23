package com.ldg.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        bean.setLoginUrl("userAdmin/notLogin");
        bean.setUnauthorizedUrl("userAdmin/notRole");
        // 添加 shiro 的内置过滤器
        /*
            anon: 无需认证就可以访问
            authc: 必须认证了才能访问
            user: 必须拥有了 记住我 功能才能访问
            perms: 拥有对某个资源的权限才能访问
            role: 拥有某个角色权限才能访问
        * */

        // 拦截
        Map<String,String> filterMap = new LinkedHashMap<>();

        // 授权
        // filterMap.put("/user/add", "anon");
        bean.setFilterChainDefinitionMap(filterMap);
        // 设置登录的请求
        // bean.setLoginUrl("/toLogin");

        // 设置未授权请求
        // bean.setUnauthorizedUrl("/unauthorized");
        return bean;
    }

    // 第3步: DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("AdminRealm") AdminRealm adminRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 第2步: 关联 adminRealm
        securityManager.setRealm(adminRealm);
        return securityManager;
    }

    // 第1步： 创建 realm 对象 需要自定义
    @Bean
    public AdminRealm AdminRealm(@Qualifier("matcher") HashedCredentialsMatcher matcher){
        AdminRealm adminRealm = new AdminRealm();
        //授权缓存，即缓存AuthorizationInfo信息，默认false
        adminRealm.setAuthorizationCachingEnabled(false);
        adminRealm.setCredentialsMatcher(matcher);
        return adminRealm;
    }

    // 第1步： 创建 realm 对象 需要自定义
    @Bean
    public UserRealm UserRealm(@Qualifier("matcher") HashedCredentialsMatcher matcher){
        UserRealm userRealm = new UserRealm();
        //授权缓存，即缓存AuthorizationInfo信息，默认false
        userRealm.setAuthorizationCachingEnabled(false);
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    /**
     * 密码匹配凭证管理器
     *
     * @return
     */
    @Bean(name = "matcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        hashedCredentialsMatcher.setHashIterations(2);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

}
