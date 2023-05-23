package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author: Sineike
 * @description: TODO
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "目标服务器宕机，调用paymentInfo_OK方法失败, 已fallback....";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "目标服务器宕机，调用paymentInfo_Timeout方法失败, 已fallback....";
    }
}
