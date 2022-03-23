package com.ldg.service.Impl;


import com.ldg.dao.OrderDao;
import com.ldg.entity.Order;
import com.ldg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Map<String, Object>> selectAllOrder(Integer userId) {
        return orderDao.selectAllOrder(userId);
    }

    @Override
    public Map<String, Object> selectOrder(String orderNo) {
        return orderDao.selectOrder(orderNo);
    }

    @Override
    public List<Map<String,Object>> selectOrderById(Integer orderId) {
        return orderDao.selectOrderById(orderId);
    }

    @Override
    public Map<String,Object> selectOrderByNo(String orderNo) {
        return orderDao.selectOrderByNo(orderNo);
    }

    @Override
    public Order findOrderByNo(String orderNo) {
        return orderDao.findOrderByNo(orderNo);
    }

    @Override
    public Boolean insertData(Order order) {
        return orderDao.insertData(order);
    }

    @Override
    public Boolean updateByNo(Order order) {
        return orderDao.updateByNo(order);
    }

    @Override
    public Boolean updateById(Order order) {
        return orderDao.updateById(order);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return orderDao.deleteById(id);
    }

    @Override
    public Map<String, Object> selectOrderData() {
        return orderDao.selectOrderData();
    }

    @Override
    public List<Order> selectOrders() {
        return orderDao.selectOrders();
    }

    @Override
    public List<Map<String,Object>> selectProductAndType() {
        return orderDao.selectProductAndType();
    }

    @Override
    public List<Map<String, Object>> selectOrderLineChart(String startTime, String endTime) {
        return orderDao.selectOrderLineChart(startTime,endTime);
    }

    @Override
    public Map<String, Object> selectCompareData() {
        return orderDao.selectCompareData();
    }

    @Override
    public List<Order> selectOrdersByMap(Map map) {
        return orderDao.selectOrdersByMap(map);
    }

    @Override
    public List<Map<String, Object>> selectAllOrderByKey(Integer userId, String key) {
        return orderDao.selectAllOrderByKey(userId, key);
    }

    @Override
    public Integer getOrderCountByCon(Map map) {
        return orderDao.getOrderCountByCon(map);
    }
}
