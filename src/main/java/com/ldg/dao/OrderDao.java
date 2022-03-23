package com.ldg.dao;

import com.ldg.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDao extends BaseDao<Order>{

    /*查询全部订单基本信息*/
    List<Map<String,Object>> selectAllOrder(Integer userId);
    // 查询所有订单
    List<Order> selectOrders();
    // 多条件查询订单
    List<Order> selectOrdersByMap(Map map);
    // 查询订单对应的商品分类
    List<Map<String,Object>> selectProductAndType();
    List<Map<String,Object>> selectAllOrderByKey(@Param("userId") Integer userId,@Param("key") String key);
    // 获取订单图表信息
    List<Map<String,Object>> selectOrderLineChart(@Param("startTime")String startTime, @Param("endTime")String endTime);
    /*查询订单基本信息*/
    Map<String, Object> selectOrder(String orderNo);
    // 查询比较信息
    Map<String, Object> selectCompareData();
    // 根据id查询订单
    List<Map<String,Object>> selectOrderById(Integer orderId);
    // 根据订单编号查询订单
    Map<String,Object> selectOrderByNo(String orderNo);
    // 根据订单编号查询订单
    Order findOrderByNo(String orderNo);
    //通过订单编号更新
    Boolean updateByNo(Order order);
    //查询订单数据
    Map<String,Object> selectOrderData();

    List<Integer> selectStateSuccess();

    List<Integer> selectWaitPay();

    // 根据条件查询记录
    Integer getOrderCountByCon(Map map);




}
