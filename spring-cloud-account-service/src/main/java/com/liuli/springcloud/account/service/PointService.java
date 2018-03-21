package com.liuli.springcloud.account.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通过Feign调用服务的接口
 * Created by li.liu on 2018/3/21.
 */

@FeignClient(name = "POINT-SERVICE", fallback = PointService.PointServiceHystrix.class)
public interface PointService {

    @RequestMapping(value = "/point/{userId}", method = RequestMethod.GET)
    @ResponseBody
    String point(@PathVariable("userId") String userId) throws InterruptedException;

    /**
     * 积分服务熔断器
     * Created by li.liu on 2018/3/21.
     */
    @Component
    class PointServiceHystrix implements PointService {

        @Override
        public String point(String userId) throws InterruptedException {
            return "{result: \"point service is down\"}";
        }
    }
}
