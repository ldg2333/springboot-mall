package com.ldg.controller.mall;

import com.ldg.entity.Order;
import com.ldg.service.OrderService;
import com.ldg.utils.MyFinal;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/getAllOrder")
    public ResultInfo getAllOrder(Integer userId){
        try {
            List<Map<String, Object>> maps = orderService.selectAllOrder(userId);
            return ResultInfo.success("获取订单列表成功",maps);
        }catch (Exception e){
            return ResultInfo.error("获取订单列表失败");
        }
    }

        @RequestMapping("/getAllOrderByKey")
    public ResultInfo getAllOrderByKey(Integer userId,String key){
            System.out.println("userId:"+userId);
            System.out.println("key:"+key);
        try {
            List<Map<String, Object>> maps = orderService.selectAllOrderByKey(userId,key);
            return ResultInfo.success("获取订单列表成功",maps);
        }catch (Exception e){
            return ResultInfo.error("获取订单列表失败");
        }
    }

    @RequestMapping("/getOrderById")
    public ResultInfo getOrderById(Integer orderId){
        try {
            List<Map<String,Object>> order = orderService.selectOrderById(orderId);
            return ResultInfo.success("查询订单成功",order);
        }catch (Exception e){
            return ResultInfo.error("查询订单失败");
        }
    }

    @RequestMapping("/addOrder")
    public ResultInfo addOrder(@RequestBody List<Order> list){
        Order o = null;
        for(Order order:list){
            order.setOrderCreateTime(new Date());
            order.setOrderState(0);
            order.setOrderUrl(order.getOrderUrl().substring(order.getOrderUrl().indexOf(MyFinal.HOST)+21));
            o = order;
            System.out.println(order);
            try {
                orderService.insertData(order);
            }catch (Exception e){
                return ResultInfo.error("新增订单失败");
            }
        }
        return ResultInfo.success("新增订单成功",orderService.selectOrderByNo(o.getOrderNo()));
    }

    @RequestMapping("/updateOrderById")
    public ResultInfo updateOrderById(@RequestBody Order order){
        try {
            if(orderService.updateById(order)){
                return ResultInfo.success("修改订单成功",orderService.selectOrderById(order.getOrderId()));
            }
            return ResultInfo.error("修改订单失败");
        }catch (Exception e){
            return ResultInfo.error("修改订单失败");
        }
    }

    @RequestMapping("/updateOrderByNo")
    public ResultInfo updateOrderByNo(@RequestBody Order order){
        try {
            if(orderService.updateByNo(order)){
                return ResultInfo.success("修改订单成功");
            }
            return ResultInfo.error("修改订单失败");
        }catch (Exception e){
            return ResultInfo.error("修改订单失败");
        }
    }

    @RequestMapping("/deleteOrderById")
    public ResultInfo deleteOrderById(Integer orderId){
        try {
            if(orderService.deleteById(orderId)){
                return ResultInfo.success("删除订单成功");
            }
            return ResultInfo.error("删除订单失败");
        }catch (Exception e){
            return ResultInfo.error("删除订单失败");
        }
    }

}
