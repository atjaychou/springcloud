package com.atguigu.cloud.controller;

import com.atguigu.cloud.lb.LoadBalancer;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author: Sineike
 * @description: TODO
 */
@RestController
@Slf4j
public class OrderController {

    // EurekaServer单机版
    // public static final String PAYMENT_URL = "http://localhost:8001";
     public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;


    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
//            log.info("Body: " + entity.getBody());
//            log.info("StatusCode: " + entity.getStatusCode());
//            log.info("Headers: " + entity.getHeaders());
//            log.info("StatusCodeValue: " + entity.getStatusCodeValue());
            return entity.getBody();
        }else {
            return new CommonResult(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/postForEntity")
    public CommonResult postPayment2(Payment payment) {
        ResponseEntity<CommonResult> postForEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (postForEntity.getStatusCode().is2xxSuccessful()) {
            return postForEntity.getBody();
        }else {
            return new CommonResult<>(444, "添加失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getMyLBServerPort() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance services = loadBalancer.services(instances);
        URI uri = services.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

}
