package com.liuli.springcloud.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by li.liu on 2018/03/21.
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启FeignClient支持
@EnableCircuitBreaker //启用断路器功能hystrix
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @LoadBalanced//开启负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
