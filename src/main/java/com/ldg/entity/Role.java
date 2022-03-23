package com.ldg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role implements Serializable {
    private Integer roleId;         //角色id
    private String roleName;        //角色昵称
    private Integer roleState;      //是否启用
}
