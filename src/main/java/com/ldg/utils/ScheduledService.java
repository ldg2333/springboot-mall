package com.ldg.utils;

import com.ldg.dao.OrderDao;
import com.ldg.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ScheduledService {

    @Autowired
    private OrderDao orderDao;

    // 在一个特定的时间执行这个方法 Timer

    // cron 表达式
    // 秒 分 时 日 月 周几
    /*
    * 0 57 10 * * ? 每天的 10点57分0秒执行
    * 0 0/5 10,18 * * ? 每天的 10点和18点 每隔5分钟执行一次
    * 0 57 10 ? * 1-6 每个月的周一到周六 10点57分执行一次
    * */
    @Scheduled(cron = "0 0 0 * * ?")
    public void setOrderState(){
        List<Integer> list = orderDao.selectStateSuccess();
        for (Integer value :list) {
            Order order = new Order();
            order.setOrderId(value);
            order.setOrderState(6);
            orderDao.updateById(order);
        }

        List<Integer> l = orderDao.selectWaitPay();
        for (Integer value :l) {
            Order order = new Order();
            order.setOrderId(value);
            order.setOrderState(-1);
            orderDao.updateById(order);
        }
    }

}
