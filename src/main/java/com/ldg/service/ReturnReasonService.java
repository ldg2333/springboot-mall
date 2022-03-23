package com.ldg.service;

import com.ldg.entity.ReturnReason;

import java.util.List;

public interface ReturnReasonService {
    //通过ID查询
    ReturnReason selectById(Integer reasonId);
    //查询所有
    List<ReturnReason> selectAll(String reasonName);
    /*查询所有退货原因*/
    List<String> selectAllName();
    //判断退货原因名称是否存在
    Boolean existsWithReasonName(Integer reasonId, String reasonName);
    //插入一条数据
    Boolean insertData(ReturnReason returnReason);

    //通过ID更新
    Boolean updateById(ReturnReason returnReason);

    //通过ID删除
    Boolean deleteById(Integer reasonId);
}
