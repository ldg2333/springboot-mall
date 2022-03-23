package com.ldg.controller.mall;

import com.alipay.api.AlipayApiException;
import com.ldg.entity.Order;
import com.ldg.service.AlipayService;
import com.ldg.service.OrderService;
import com.ldg.service.ProductService;
import com.ldg.service.ShopCartService;
import com.ldg.utils.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/alipay")
@CrossOrigin
@RestController
@Slf4j
public class AlipayController {

    @Autowired
    private ShopCartService ShopCartService;
    @Autowired
    private  AlipayService alipayService;
    @Autowired
    private  OrderService orderService;
    @Autowired
    private ProductService productService;

    private List<String> orderNoList = new ArrayList<>();


    @PostMapping(value = "/create", produces = "text/html;charset=utf-8")
    public String create(@RequestParam("orderNo") String orderNo,
                         @RequestParam("orderName") String orderName,
                         @RequestParam("payPrice") String payPrice) {
        //发起支付
        return alipayService.create(orderNo, orderName, payPrice);
    }

    @RequestMapping(value = "/refund")
    public ResultInfo refund(@RequestParam("orderNo") String orderNo,
                             @RequestParam("payPrice") String payPrice) {
        //发起退款
        try {
            alipayService.refund(orderNo, payPrice);
        } catch (AlipayApiException e) {
            log.info("【支付宝支付】退款失败 error={}", e.toString());
        }
        return ResultInfo.success("退款成功");
    }

    @GetMapping(value = "/success")
    public void success(@RequestParam Map<String, String> map, HttpServletResponse response) {
        try {
            for(String orderNo : orderNoList){
                Order order = orderService.findOrderByNo(orderNo);
                productService.updateByNo(order.getProductNo(), order.getPayAmount(),order.getPayAmount());
                order.setOrderPayTime(new Date());
                order.setOrderState(1);
                orderService.updateById(order);
            }
            response.sendRedirect("http://localhost:" + "8080" + "/mall/Order");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @PostMapping(value = "/notifyUrl")
    public void payNotify(@RequestParam Map<String, String> map) {
        String tradeStatus = map.get("trade_status");
        if (tradeStatus.equals("TRADE_SUCCESS")) {
            String payTime = map.get("gmt_payment");
            String tradeNo = map.get("out_trade_no");
            String tradeName = map.get("subject");
            String payAmount = map.get("buyer_pay_amount");
            log.info("[支付成功] {交易时间：{},订单号：{},订单名称：{},交易金额：{}}", payTime, tradeNo, tradeName, payAmount);
        }
    }

    @PostMapping(value = "/setOrderList")
    public void setOrderList(@RequestBody  List<String> list) {
        this.orderNoList = list;
    }

}
