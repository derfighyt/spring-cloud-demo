package com.liuli.springcloud.account.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 通过Feign调用服务的接口
 * Created by li.liu on 2018/3/21.
 */

@FeignClient(value = "point-service", fallback = PointServiceHystrix.class)
public interface PointService {

    @RequestMapping(value = "/point/{userId}", method = RequestMethod.GET)
    String point(@PathVariable String userId) throws InterruptedException;
}
