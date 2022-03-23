package com.ldg.controller.mall;

import com.ldg.entity.User;
import com.ldg.service.UserService;
import com.ldg.utils.MyFinal;
import com.ldg.utils.ResultInfo;
import com.ldg.utils.TokenProcessor;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.security.PublicKey;
import java.util.*;

/**
 * 关于商城用户的登录、注册、修改等功能
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //未登录时，将被转发到此请求上
    @RequestMapping("/notLogin")
    public ResultInfo toLogin() {
        return new ResultInfo(401, "请登录！");
    }

    /**
     * 登录操作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultInfo userLogin(@RequestBody User user) {
        System.out.println(user);
        try {
            if (user.getAccountNumber() == null) {
                throw new AuthenticationException();
            }
            if (user.getPassword() == null) {
                throw new IncorrectCredentialsException();
            }

            Map<String, Object> info = new HashMap<>();
            // 加密密码验证
            SimpleHash md5 = new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes(user.getAccountNumber()), 2);
            user.setPassword(md5.toHex());
            User uTemp = userService.findUserByNumber(user.getAccountNumber());
            User u = userService.loginMall(user);
            if(uTemp == null){
                throw new AuthenticationException();
            }
            if(u == null){
                throw new IncorrectCredentialsException();
            }
            if(u.getUserState() == 0){
                throw new LockedAccountException();
            }
            u.setAvatarUrl(MyFinal.HOST + u.getAvatarUrl());
            info.put("user", u);      //存放用户信息
            //存放sessionId, 即 token
            info.put("token", TokenProcessor.makeToken());
            return ResultInfo.success("登录成功", info);
        } catch (LockedAccountException e) {
            return ResultInfo.error("帐号异常，已被封停（请联系工作人员邮箱1782646017@qq.com",501);
        } catch (IncorrectCredentialsException e) {
            return ResultInfo.error("账号或密码错误,请重新输入",502);
        } catch (AuthenticationException e) {
            return ResultInfo.error("该用户不存在",503);
        }
    }

    /**
     * 注册新用户
     * @param user
     * @return 根据要求返回响应信息
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResultInfo userRegister(@RequestBody User user) {
        System.out.println(user);
        User u = userService.findUserByNumber(user.getAccountNumber());
        if(u != null)
            return ResultInfo.error("当前用户已存在,请勿重复注册!");
        if (user.getPassword() != null && user.getAccountNumber() != null) {
            SimpleHash md5 = new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes(user.getAccountNumber()), 2);
            user.setPassword(md5.toHex()); // 密码加密
            user.setUserState(1); // 默认可用
            user.setCreateTime(new Date()); // 当前时间
            user.setUserName(user.getAccountNumber()); // 用户名默认为当前账户名
            user.setSex("男"); // 性别默认为男性
            user.setTelephone(user.getAccountNumber()); // 电话默认为当前账户名
            if (userService.insertData(user)) {
                return ResultInfo.success("注册成功!", user);
            } else {
                return ResultInfo.error("注册失败,请稍后重试!");
            }
        }
        return ResultInfo.error("用户数据不存在!");
    }

    @RequestMapping("/testPassword")
    public ResultInfo testPassword(@RequestBody User user){
        SimpleHash md5 = new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes(user.getAccountNumber()), 2);
        user.setPassword(md5.toHex()); // 密码加密
        User u = userService.loginMall(user);
        if(u != null){
            return ResultInfo.success("密码正确",u);
        }
        return ResultInfo.error("密码错误");
    }

    @RequestMapping("/updateUserInfo")
    public ResultInfo updateUserInfo(@RequestBody User user){
        if(user.getAvatarUrl() != null){
            user.setAvatarUrl(user.getAvatarUrl().substring(user.getAvatarUrl().indexOf(MyFinal.HOST)+21));
        }
        System.out.println(user);
        if(user.getPassword()!=null){
            SimpleHash md5 = new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes(user.getAccountNumber()), 2);
            user.setPassword(md5.toHex()); // 密码加密
        }
        if(userService.updateById(user)){
            User u = userService.findUserByNumber(user.getAccountNumber());
            u.setAvatarUrl(MyFinal.HOST + u.getAvatarUrl());
            return ResultInfo.success("修改用户信息成功",u);
        }
        return ResultInfo.success("修改用户信息失败");
    }



    /**
     * 退出登录操作
     */
    @RequestMapping(value = "/logout")
    public ResultInfo logout() {
        // try {
        //     Subject subject = SecurityUtils.getSubject();
        //     //清除用户缓存
        //     RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        //     UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
        //     userRealm.clearCache(SecurityUtils.getSubject().getPrincipals());
        //     //退出登录
        //     subject.logout();
        //     return ResultInfo.success("退出成功");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        return ResultInfo.success("退出成功!");
    }

    @GetMapping("getUserInfo")
    public ResultInfo getUserInfo(String accountNumber){
        try {
            User u = userService.findUserByNumber(accountNumber);
            u.setAvatarUrl(MyFinal.HOST + u.getAvatarUrl());
            return ResultInfo.success("查询成功",u);
        }catch (Exception e){
            return ResultInfo.success("查询失败");
        }

    }

}
