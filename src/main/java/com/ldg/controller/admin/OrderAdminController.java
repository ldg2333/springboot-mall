package com.ldg.controller.admin;

import com.ldg.entity.Order;
import com.ldg.entity.Product;
import com.ldg.service.OrderService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("orderAdmin")
@CrossOrigin
public class OrderAdminController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("/getOrderData")
    public ResultInfo getOrderData(){
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> orderMap = orderService.selectOrderData();
        if (orderMap != null) {
            resultMap.putAll(orderMap);
        }

        if (resultMap.size() != 0) {
            return ResultInfo.success("查询成功", resultMap);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/selectOrders")
    public ResultInfo selectOrders(){
        try {
            List<Order> orders = orderService.selectOrders();
            return ResultInfo.success("查询成功", orders);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/selectPAndT")
    public ResultInfo selectProductAndType(){
        try {
            List<Map<String, Object>> maps = orderService.selectProductAndType();
            return ResultInfo.success("查询成功", maps);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/selectOLC")
    public ResultInfo selectOrderLineChart(String startTime,String endTime){
        try {
            List<Map<String, Object>> maps = orderService.selectOrderLineChart(startTime, endTime);
            return ResultInfo.success("查询成功", maps);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/selectCO")
    public ResultInfo selectCompareOrder(){
        try {
            Map<String, Object> maps = orderService.selectCompareData();
            return ResultInfo.success("查询成功", maps);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/selectByMap")
    public ResultInfo selectByMap(@RequestBody Map map){
        System.out.println(map);
        if(map.get("orderState")!= null && map.get("orderState").equals("")){
            map.put("orderState",null);
        }
        try {

            Map<String,Object> m = new HashMap<>();
            List<Order> orders = orderService.selectOrdersByMap(map);
            Integer orderCount = orderService.getOrderCountByCon(map);
            m.put("orders", orders);
            m.put("orderCount", orderCount);
            return ResultInfo.success("查询成功", m);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

}
