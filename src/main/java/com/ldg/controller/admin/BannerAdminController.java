package com.ldg.controller.admin;

import com.alibaba.fastjson.JSON;
import com.ldg.entity.Banner;
import com.ldg.entity.ProductType;
import com.ldg.service.BannerService;
import com.ldg.utils.FileUtil;
import com.ldg.utils.MyFinal;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/bannerAdmin")
@CrossOrigin
public class BannerAdminController {
    
    @Autowired
    private BannerService bannerService;


    /*商品类别*/
    @RequestMapping(value = "/addBanner")
    public ResultInfo addBanner(@RequestParam(value="file",required = false) MultipartFile file, @RequestParam("banner") String banner) {
        try {
            Banner b = JSON.parseObject(banner, Banner.class);
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = FileUtil.getFileName() + suffixName;
            b.setBannerUrl(MyFinal.BANNER_URL + newFileName);
            FileUtil.uploadFile(file, MyFinal.BANNER_FILE_DIC,newFileName);
            bannerService.insertData(b);
            return ResultInfo.success("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("新增失败");
        }
    }

    @RequestMapping("/deleteBannerUrl")
    public ResultInfo deleteBannerUrl(String bannerUrl) {
        if (FileUtil.deleteFile(MyFinal.BANNER_FILE_DIC, bannerUrl) == 1) {//存在就删了
            return ResultInfo.success("删除成功");
        } else if (FileUtil.deleteFile(MyFinal.BANNER_FILE_DIC, bannerUrl) == 0) {
            return ResultInfo.error("文件删除失败");
        } else {
            return ResultInfo.error("文件不存在");
        }
    }

    @RequestMapping("/updateBannerExistUrl")
    public ResultInfo updateBannerExistUrl(@RequestParam(value="file",required = false) MultipartFile file, @RequestParam("banner") String banner){
        try {
            Banner b = JSON.parseObject(banner, Banner.class);
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = FileUtil.getFileName() + suffixName;
            b.setBannerUrl(MyFinal.BANNER_URL + newFileName);
            FileUtil.uploadFile(file, MyFinal.BANNER_FILE_DIC,newFileName);
            bannerService.updateById(b);
            return ResultInfo.success("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("修改失败");
        }


    }

    @RequestMapping("/updateBanner")
    public ResultInfo updateBanner(@RequestBody Banner banner){
        try {
            if(bannerService.updateById(banner))
                return ResultInfo.success("修改成功");
            return ResultInfo.error("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("修改失败");
        }
    }

    @RequestMapping(value = "/deleteById")
    public ResultInfo deleteTypeById(Integer bannerId) {
        if (bannerService.deleteById(bannerId)) {
            return ResultInfo.success("商品轮播图删除成功", "bannerId: " + bannerId);
        } else {
            return ResultInfo.error("商品轮播图删除失败");
        }
    }


    @RequestMapping(value = "/findAll")
    public ResultInfo findAllByName(String bannerName) {
        List<Banner> banners = bannerService.selectAllByName(bannerName);
        if (banners != null) {
            return ResultInfo.success("商品轮播图查询成功", banners);
        } else {
            return ResultInfo.error("商品轮播图查询失败");
        }
    }

    @RequestMapping(value = "/findById")
    public ResultInfo findById(Integer bannerId) {
        Banner banner = bannerService.selectById(bannerId);
        if (banner != null) {
            return ResultInfo.success("商品轮播图查询成功", banner);
        } else {
            return ResultInfo.error("商品轮播图查询失败");
        }
    }

}
