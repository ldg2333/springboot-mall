package com.ldg.controller.admin;

import com.ldg.entity.Role;
import com.ldg.service.RoleService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roleAdmin")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("getAllRole")
    public ResultInfo getAllRole(){
        try {
            List<Role> roles = roleService.selectAllUsable();
            return ResultInfo.success("查询成功",roles);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @GetMapping("getAllRoleByName")
    public ResultInfo getAllRoleByName(String roleName){
        try {
            List<Role> roles = roleService.selectAllByName(roleName);
            return ResultInfo.success("查询成功",roles);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @PutMapping("updateRole")
    public ResultInfo updateRole(@RequestBody Role role){
        try {
            if(roleService.updateById(role))
                return ResultInfo.success("更新成功");
            return ResultInfo.error("更新失败");
        }catch (Exception e){
            return ResultInfo.error("更新失败");
        }
    }

    @PostMapping("addRole")
    public ResultInfo addRole(@RequestBody Role role){
        try {
            if(roleService.insertData(role))
                return ResultInfo.success("新增成功");
            return ResultInfo.error("新增失败");
        }catch (Exception e){
            return ResultInfo.error("新增失败");
        }
    }

    @DeleteMapping("deleteRole")
    public ResultInfo deleteRole(Integer roleId){
        try {
            if(roleService.deleteById(roleId))
                return ResultInfo.success("删除成功");
            return ResultInfo.error("删除失败");
        }catch (Exception e){
            return ResultInfo.error("删除失败");
        }
    }

}
