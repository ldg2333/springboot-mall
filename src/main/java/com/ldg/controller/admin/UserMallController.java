package com.ldg.controller.admin;

import com.ldg.entity.User;
import com.ldg.service.UserService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("userMall")
@RestController
@CrossOrigin
public class UserMallController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    public ResultInfo getUserInfo(){
        try {
            return ResultInfo.success("查询成功",userService.userInfo());
        }catch (Exception e){
            return ResultInfo.error("查询失败");
        }
    }

    @GetMapping("/getAllUser")
    public ResultInfo getAllUser(String key){
        try {
            List<User> users = userService.selectAllUserByCon(key);
            return ResultInfo.success("查询成功",users);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @PostMapping("/updateUserById")
    public ResultInfo updateUserById(@RequestBody User user){
        try {
            if(userService.updateById(user)){
                return ResultInfo.success("修改成功");
            }
            return ResultInfo.error("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("修改失败");
        }
    }
}
