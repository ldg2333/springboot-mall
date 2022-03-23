package com.ldg.service;

import com.ldg.entity.Address;
import com.ldg.entity.Banner;

import java.util.List;

public interface AddressService {

    //通过ID查询
    List<Address> selectAllByUserId(Integer userId);
    //查询所有
    List<Address> selectAll();

    //通过ID查询
    Address selectById(Integer id);

    //插入一条数据
    Boolean insertData(Address address);
    //通过ID更新
    Boolean updateById(Address address);
    //通过ID删除
    Boolean deleteById(Integer addressId);

    // 判断是否存在默认地址
    Address existsDefaultAddress(Address address);

}
