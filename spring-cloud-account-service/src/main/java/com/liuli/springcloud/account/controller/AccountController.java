package com.liuli.springcloud.account.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liuli.springcloud.account.service.PointService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 账户服务API
 * Created by li.liu on 2018/03/21.
 */

@RestController
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private PointService pointService;

    /**
     * 熔断器
     * @return
     */
    public String infoFallback(String userId) {
        return "point service is down";
    }

    /**
     * 通过Ribbon调用积分服务
     * @param userId
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = "/info/{userId}", method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod = "infoFallback")
    public String info(@PathVariable String userId) throws InterruptedException {
        logger.info("account-service#info is called");

        //ServiceInstance serviceInstance = loadBalancerClient.choose("POINT-SERVICE");
        String pointServiceResult =
                restTemplate.getForEntity("http://POINT-SERVICE/point/" + userId, String.class).getBody();
        String point = (String)JSON.parseObject(pointServiceResult).get("result");
        String message = "Hello " + userId + "\n";

        JSONObject object = new JSONObject();
        object.put("message", message);
        object.put("point", point);
        return object.toJSONString();
    }

    /**
     * 通过Feign调用积分服务
     * @param userId
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = "/infoFeign/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String infoFeign(@PathVariable String userId) throws InterruptedException {
        logger.info("account-service#infoFeign is called");

        String pointServiceResult = pointService.point(userId);
        String point = (String)JSON.parseObject(pointServiceResult).get("result");
        String message = "Hello " + userId + "\n";

        JSONObject object = new JSONObject();
        object.put("message", message);
        object.put("point", point);
        return object.toJSONString();
    }
}
