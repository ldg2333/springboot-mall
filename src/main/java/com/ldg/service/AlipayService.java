package com.ldg.service;

import com.alipay.api.AlipayApiException;

public interface AlipayService {
    String create(String orderNo, String orderName, String payPrice);

    void refund(String orderNo, String payPrice) throws AlipayApiException;
}