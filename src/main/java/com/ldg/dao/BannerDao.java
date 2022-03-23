package com.ldg.dao;
import com.ldg.entity.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerDao extends BaseDao<Banner> {
    //查询所有
    List<Banner> selectAllByName(@Param("bannerName") String bannerName);
}
