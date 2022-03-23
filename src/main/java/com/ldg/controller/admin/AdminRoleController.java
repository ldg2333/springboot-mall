package com.ldg.controller.admin;

import com.ldg.entity.AdminRole;
import com.ldg.entity.Role;
import com.ldg.service.AdminRoleService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("adminRole")
@CrossOrigin
public class AdminRoleController {

    @Autowired
    private AdminRoleService adminRoleService;

    @GetMapping("getRolesById")
    public ResultInfo getRolesById(Integer adminId){
        try {
            List<Map<String, Object>> maps = adminRoleService.selectRoleByAdminId(adminId);
            return ResultInfo.success("查询成功",maps);
        }catch (Exception e){
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("deleteRoleByList")
    public ResultInfo deleteRoleByList(@RequestBody List<AdminRole> list){
        try {
            if(adminRoleService.deleteByList(list))
                return ResultInfo.success("删除成功");
            return ResultInfo.success("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("删除失败");
        }
    }

    @RequestMapping("deleteRoleById/{adminId}")
    public ResultInfo deleteRoleByList(@PathVariable Integer adminId){
        try {
            if(adminRoleService.deleteById(adminId))
                return ResultInfo.success("删除成功");
            return ResultInfo.success("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("删除失败");
        }
    }

    @RequestMapping("addRoleByList")
    public ResultInfo addRoleByList(@RequestBody  List<AdminRole> list){
        try {
            if(adminRoleService.addByList(list))
                return ResultInfo.success("添加成功");
            return ResultInfo.success("添加失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("添加失败");
        }
    }
}
