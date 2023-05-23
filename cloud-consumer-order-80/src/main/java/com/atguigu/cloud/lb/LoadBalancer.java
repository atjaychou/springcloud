package com.atguigu.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    ServiceInstance services(List<ServiceInstance> serviceInstances);
}
