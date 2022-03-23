package com.ldg.controller.mall;

import com.alibaba.fastjson.JSON;
import com.ldg.entity.User;
import com.ldg.service.UserService;
import com.ldg.utils.FileUtil;
import com.ldg.utils.MyFinal;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/userUpload")
@CrossOrigin
public class UserUploadController {



    @Autowired
    private UserService userService;

    @RequestMapping({"/uploadAvatar"})
    public ResultInfo upload(@RequestParam("file") MultipartFile file, @RequestParam("user") String user) {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        String newFileName = sdf.format(new Date()) + r.nextInt(100) + suffixName;
        User u = JSON.parseObject(user, User.class);
        u.setAvatarUrl(MyFinal.USER_AVATAR_URL + newFileName);
        try {
            FileUtil.uploadFile(file, MyFinal.USER_FILE_DIC,newFileName);
            userService.updateById(u);
            return ResultInfo.success("上传头像成功", userService.findUserByNumber(u.getAccountNumber()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.error("文件上传失败");
        }
    }

    @RequestMapping("/deleteAvatar")
    public ResultInfo deleteAvatar(String preAvatar) {
        if (FileUtil.deleteFile(MyFinal.USER_AVATAR_URL, preAvatar) == 1) {//存在就删了
            return ResultInfo.success("删除成功");
        } else if (FileUtil.deleteFile(MyFinal.USER_AVATAR_URL, preAvatar) == 0) {
            return ResultInfo.error("文件删除失败");
        } else {
            return ResultInfo.error("文件不存在");
        }
    }

}
