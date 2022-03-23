package com.ldg.service;

import com.ldg.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderService{

    /*查询全部订单基本信息*/
    List<Map<String,Object>> selectAllOrder(Integer userId);
    /*查询订单基本信息*/
    Map<String, Object> selectOrder(String orderNo);
    // 根据id查询定案
    List<Map<String,Object>> selectOrderById(Integer orderId);
    // 根据订单编号查询订单
    Map<String,Object> selectOrderByNo(String orderNo);
    // 根据订单编号查询订单
    Order findOrderByNo(String orderNo);
    //插入一条数据
    Boolean insertData(Order order);
    //通过订单编号更新
    Boolean updateByNo(Order order);
    //通过ID更新
    Boolean updateById(Order order);
    //通过ID删除
    Boolean deleteById(Integer id);
    //查询订单数据
    Map<String,Object> selectOrderData();
    // 查询所有订单
    List<Order> selectOrders();
    // 查询订单对应的商品分类
    List<Map<String,Object>> selectProductAndType();
    // 获取订单图表信息
    List<Map<String,Object>> selectOrderLineChart(String startTime, String endTime);
    // 查询比较信息
    Map<String, Object> selectCompareData();
    // 多条件查询订单
    List<Order> selectOrdersByMap(Map map);

    List<Map<String,Object>> selectAllOrderByKey(Integer userId,String key);

    // 根据条件查询记录
    Integer getOrderCountByCon(Map map);

}
