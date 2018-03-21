package com.liuli.springcloud.account.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 积分服务熔断器
 * Created by li.liu on 2018/3/21.
 */
@Component
public class PointServiceHystrix implements PointService {

    @Override
    public String point(@PathVariable String userId) throws InterruptedException {
        return "{result: \"point service is down\"}";
    }
}