package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Sineike
 * @description: TODO
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/feign/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult<Payment> payment = paymentFeignService.getPaymentById(id);
        return payment;
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String feignTimeOut() {
        String timeOut = paymentFeignService.paymentFeignTimeOut();
        return timeOut;
    }
}
