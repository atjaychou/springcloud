package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: Sineike
 * @description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8002.class,args);
    }
}
