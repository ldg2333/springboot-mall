package com.ldg.controller.mall;

import com.ldg.entity.Banner;
import com.ldg.service.BannerService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/banner")
@CrossOrigin
public class BannerController {
    
    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/findAll")
    public ResultInfo findAllType() {
        List<Banner> banners = bannerService.selectAll();
        if (banners != null) {
            return ResultInfo.success("商品轮播图查询成功", banners);
        } else {
            return ResultInfo.error("商品轮播图查询失败");
        }
    }


}
