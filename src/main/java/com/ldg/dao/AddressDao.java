package com.ldg.dao;

import com.ldg.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends BaseDao<Address>{

    // 根据 userId 查询所有
    List<Address> selectAllByUserId(Integer userId);

    // 判断是否存在默认地址
    Address existsDefaultAddress(Address address);


}
