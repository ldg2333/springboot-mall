package com.ldg.controller.admin;

import com.alibaba.fastjson.JSON;
import com.ldg.config.AdminRealm;
import com.ldg.entity.Admin;
import com.ldg.entity.Role;
import com.ldg.entity.User;
import com.ldg.service.AdminService;
import com.ldg.service.RoleService;
import com.ldg.utils.FileUtil;
import com.ldg.utils.MyFinal;
import com.ldg.utils.ResultInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 管理员的登录、修改等功能
 */
@RestController
@RequestMapping("/userAdmin")
@CrossOrigin
public class UserAdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    //未登录时，将被转发到此请求上
    @RequestMapping("/notLogin")
    public ResultInfo toLogin() {
        return new ResultInfo(401, "请登录！");
    }

    /**
     * 登录操作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultInfo adminLogin(@RequestBody Admin admin) {
        try {
            if (admin.getAdminNumber() == null) {
                throw new AuthenticationException();
            }
            if (admin.getPassword() == null) {
                throw new IncorrectCredentialsException();
            }
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminNumber(), admin.getPassword());
            subject.login(token);
            Map<String, Object> info = new HashMap<>();
            String authorization = (String) subject.getSession().getId();
            Admin a = adminService.findAdminByNumber(admin.getAdminNumber());
            if(a.getAvatarUrl() != null)
                a.setAvatarUrl(MyFinal.HOST + a.getAvatarUrl());
            info.put("admin", a);      //存放用户信息

            //存放sessionId, 即 token
            info.put("token", authorization);
            List<Role> roles = roleService.selectAll();
            List<String> rs = new ArrayList<>();    // rs 存放的是role的名称
            List<String> rsInfo = new ArrayList<>();    //rsInfo 存放role的描述
            for (Role role : roles) {
                rs.add(role.getRoleName());
                rsInfo.add(role.getRoleName());
            }
            boolean[] booleans = subject.hasRoles(rs);
            for (int i = booleans.length - 1; i >= 0; i--) {
                if (!booleans[i]) {
                    rs.remove(i);
                    rsInfo.remove(i);
                }
            }
            System.out.println("rs:"+rs);
            info.put("role", rs);
            info.put("roleInfo", rsInfo);
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
     * @param admin
     * @return 根据要求返回响应信息
     */
    @RequestMapping(value = "/register")
    public ResultInfo adminRegister(@RequestBody Admin admin) {
        Admin a = adminService.findAdminByNumber(admin.getAdminNumber());
        if(a != null)
            return ResultInfo.error("当前管理员已存在 请重新输入",501);
        if (admin.getPassword() != null && admin.getAdminNumber() != null) {
            SimpleHash md5 = new SimpleHash("MD5", admin.getPassword(), ByteSource.Util.bytes(admin.getAdminNumber()), 2);
            admin.setPassword(md5.toHex());
            admin.setAdminState(1);
            admin.setCreateTime(new Date());
            if (adminService.insertData(admin)) {
                return ResultInfo.success("注册成功", admin);
            } else {
                return ResultInfo.error("注册失败");
            }
        }
        return ResultInfo.error("用户数据不存在");
    }

    /**
     * 退出登录操作
     */
    @RequestMapping(value = "/logout")
    public ResultInfo logout() {
            try {
                Subject subject = SecurityUtils.getSubject();
                //清除用户缓存
                RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
                AdminRealm userRealm = (AdminRealm) securityManager.getRealms().iterator().next();
                userRealm.clearCache(SecurityUtils.getSubject().getPrincipals());
                //退出登录
                subject.logout();
                return ResultInfo.success("退出成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return ResultInfo.error("退出失败，未找到用户帐号");
    }

    @GetMapping("/getAllByKey")
    public ResultInfo getAllAdminByKey(String key){
        try {
            List<Admin> admins = adminService.selectAllByKey(key);
            return ResultInfo.success("查询成功",admins);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @PostMapping("/updateAdmin")
    public ResultInfo updateAdmin(@RequestBody Admin admin){
        try {
            if(admin.getPassword()!=null){
                SimpleHash md5 = new SimpleHash("MD5", admin.getPassword(), ByteSource.Util.bytes(admin.getAdminNumber()), 2);
                admin.setPassword(md5.toHex()); // 密码加密
            }
            if(adminService.updateById(admin)){
                Admin adminByNumber = adminService.findAdminByNumber(admin.getAdminNumber());
                adminByNumber.setAvatarUrl(MyFinal.HOST + adminByNumber.getAvatarUrl());
                return ResultInfo.success("修改管理员信息成功",adminByNumber);
            }
            return ResultInfo.error("修改管理员信息失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("修改管理员信息失败");
        }
    }

    @DeleteMapping("deleteAdmin/{adminId}")
    public ResultInfo deleteAdminById(@PathVariable("adminId") Integer adminId){
        try {
            if(adminService.deleteById(adminId))
                return  ResultInfo.success("删除成功");
            return ResultInfo.error("删除失败");
        }catch (Exception e){
            return ResultInfo.error("删除失败");
        }
    }

    @DeleteMapping("deleteAdminAvatar")
    public ResultInfo deleteAdminById(String avatarUrl){
        if (FileUtil.deleteFile(MyFinal.USER_FILE_DIC, avatarUrl) == 1) {//存在就删了
            return ResultInfo.success("删除成功");
        } else if (FileUtil.deleteFile(MyFinal.USER_FILE_DIC, avatarUrl) == 0) {
            return ResultInfo.error("文件删除失败");
        } else {
            return ResultInfo.error("文件不存在");
        }
    }

    @GetMapping("getAdminById/{adminId}")
    public ResultInfo getAdminById(@PathVariable("adminId") Integer adminId){
        try {
            Admin admin = adminService.selectById(adminId);
            if(admin.getAvatarUrl() != null)
                admin.setAvatarUrl(MyFinal.HOST + admin.getAvatarUrl());
            return ResultInfo.success("查询成功",admin);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping({"/updateAdminWithUrl"})
    public ResultInfo updateAdminWithUrl(@RequestParam("file") MultipartFile file, @RequestParam("admin") String admin) {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        String newFileName = sdf.format(new Date()) + r.nextInt(100) + suffixName;
        Admin a = JSON.parseObject(admin, Admin.class);
        a.setAvatarUrl(MyFinal.USER_AVATAR_URL + newFileName);
        try {
            FileUtil.uploadFile(file, MyFinal.USER_FILE_DIC,newFileName);
            System.out.println(a);
            adminService.updateById(a);
            Admin adminByNumber = adminService.findAdminByNumber(a.getAdminNumber());
            adminByNumber.setAvatarUrl(MyFinal.HOST + adminByNumber.getAvatarUrl());
            return ResultInfo.success("上传头像成功", adminByNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.error("文件上传失败");
        }
    }
}
