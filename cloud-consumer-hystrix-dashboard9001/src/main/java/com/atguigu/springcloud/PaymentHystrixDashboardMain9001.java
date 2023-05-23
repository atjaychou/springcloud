package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: Sineike
 * @description: TODO
 */
@SpringBootApplication
@EnableHystrixDashboard
public class PaymentHystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixDashboardMain9001.class, args);
    }
}
