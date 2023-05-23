package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: Sineike
 * @description: TODO
 */
@RestController
public class PaymentController {

    private static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getConsulInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }



}
