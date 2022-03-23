package com.ldg.service;

import com.ldg.entity.Banner;

import java.util.List;

public interface BannerService {
    //通过ID查询
    Banner selectById(Integer bannerId);
    //查询所有
    List<Banner> selectAll();

    //插入一条数据
    Boolean insertData(Banner banner);
    //通过ID更新
    Boolean updateById(Banner banner);
    //通过ID删除
    Boolean deleteById(Integer bannerId);
    //查询所有
    List<Banner> selectAllByName(String bannerName);
}
