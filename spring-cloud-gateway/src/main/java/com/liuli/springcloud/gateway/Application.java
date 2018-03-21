package com.liuli.springcloud.gateway;

import com.liuli.springcloud.gateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by li.liu on 2017/11/16.
 * SpringCloudApplication 整合了SpringBootApplication, EnableDiscoveryClient服务发现, EnableCircuitBreaker断路器
 */

@SpringCloudApplication
@EnableZuulProxy
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
