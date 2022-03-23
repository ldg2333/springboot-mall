package com.ldg.controller.mall;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldg.entity.Address;
import com.ldg.entity.Product;
import com.ldg.service.AddressService;
import com.ldg.utils.ResultInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/getAllAddress")
    public ResultInfo getAllAddress(Integer userId){
        try {
            List<Address> addresses = addressService.selectAllByUserId(userId);
            return ResultInfo.success("获取收货地址成功!",addresses);
        }catch (Exception e){
            return ResultInfo.error("获取收货地址失败!");
        }
    }

    // 设为默认地址
    @RequestMapping("/setDefault")
    public ResultInfo setDefaultAddress(Integer addressId,Integer userId){
        System.out.println("addressId:"+addressId);
        System.out.println("userId:"+userId);
        Address address = addressService.existsDefaultAddress(new Address(null, 1, userId));
        if(address != null){
            if(address.getIsDefault() == 1){
                addressService.updateById(new Address(address.getAddressId(),0,null));
            }
        }
        if(addressService.updateById(new Address(addressId,1,userId))) {
            return ResultInfo.success("设为默认地址成功!",addressService.selectAllByUserId(userId));
        }
        return ResultInfo.error("设为默认地址失败!");
    }

    // 根据id查询
    @RequestMapping("/getAddressById")
    public ResultInfo getAddressById(Integer id){
        try {
            Address addresses = addressService.selectById(id);
            return ResultInfo.success("获取收货地址成功!",addresses);
        }catch (Exception e){
            return ResultInfo.error("获取收货地址失败!");
        }
    }

    // 更改收货地址信息
    @RequestMapping("/updateAddress")
    public ResultInfo updateAddress(@RequestBody Address address){
        System.out.println(address);
        try {
            if(addressService.updateById(address))
                return ResultInfo.success("修改收货地址成功!");
            return ResultInfo.error("获取收货地址失败!");
        }catch (Exception e){
            return ResultInfo.error("获取收货地址失败!");
        }
    }

    // 更改收货地址信息
    @RequestMapping("/addAddress")
    public ResultInfo addAddress(@RequestBody Address address){
        try {
            if(addressService.insertData(address)){
                if(addressService.selectAllByUserId(address.getUserId()).size() == 1){
                    List<Address> a = addressService.selectAllByUserId(address.getUserId());
                    addressService.updateById(new Address(a.get(0).getAddressId(),1,address.getUserId()));
                }
                return ResultInfo.success("新增收货地址成功!");
            }
            return ResultInfo.error("新增收货地址失败!");
        }catch (Exception e){
            return ResultInfo.error("新增收货地址失败!");
        }
    }

    // 更改收货地址信息
    @RequestMapping("/deleteAddress")
    public ResultInfo deleteAddress(Integer addressId){
        try {
            if(addressService.deleteById(addressId))
                return ResultInfo.success("删除收货地址成功!");
            return ResultInfo.error("删除收货地址失败!");
        }catch (Exception e){
            return ResultInfo.error("删除收货地址失败!");
        }
    }
}
