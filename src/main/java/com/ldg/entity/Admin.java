package com.ldg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private Integer adminId;         //管理员id
    private String adminNumber;   //帐号
    private String adminName;        //昵称
    private String password;        //密码
    private String sex;         //性别
    private String telephone;       //手机号
    private Date createTime;         //注册时间
    private Integer adminState;      //用户状态
    private String avatarUrl;       //头像链接
}
