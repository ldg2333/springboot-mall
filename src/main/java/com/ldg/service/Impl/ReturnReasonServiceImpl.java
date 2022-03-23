package com.ldg.service.Impl;

import com.ldg.dao.ReturnReasonDao;
import com.ldg.entity.ReturnReason;
import com.ldg.service.ReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ReturnReasonServiceImpl implements ReturnReasonService {


    @Autowired
    private ReturnReasonDao returnReasonDao;

    @Override
    public ReturnReason selectById(Integer reasonId) {
        return returnReasonDao.selectById(reasonId);
    }

    @Override
    public List<ReturnReason> selectAll(String reasonName) {
        return returnReasonDao.selectAll(reasonName);
    }

    @Override
    public List<String> selectAllName() {
        return returnReasonDao.selectAllName();
    }

    @Override
    public Boolean existsWithReasonName(Integer reasonId,String reasonName) {
        return returnReasonDao.existsWithReasonName(reasonId,reasonName);
    }

    @Override
    public Boolean insertData(ReturnReason returnReason) {
        return returnReasonDao.insertData(returnReason);
    }

    @Override
    public Boolean updateById(ReturnReason returnReason) {
        return returnReasonDao.updateById(returnReason);
    }

    @Override
    public Boolean deleteById(Integer reasonId) {
        return returnReasonDao.deleteById(reasonId);
    }
}
