package com.ldg.dao;

import com.ldg.entity.ReturnReason;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnReasonDao extends BaseDao<ReturnReason> {
    /*查询所有退货原因*/
    List<String> selectAllName();
    //判断退货原因名称是否存在
    Boolean existsWithReasonName(@Param("reasonId") Integer reasonId, @Param("reasonName") String reasonName);

    //查询所有
    List<ReturnReason> selectAll(@Param("reasonName") String reasonName);
}
