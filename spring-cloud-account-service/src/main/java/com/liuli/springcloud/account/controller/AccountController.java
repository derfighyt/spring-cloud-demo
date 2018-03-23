package com.liuli.springcloud.account.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liuli.springcloud.account.bean.UserInfo;
import com.liuli.springcloud.account.service.PointService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.*;
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
@Api(description = "账户服务接口", tags = "v1.0")
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
    @ApiOperation(value = "用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户名", required = true, dataType = "String", paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "返回用户信息", response = String.class)
    })
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
    @ApiOperation(value = "用户信息(Feign客户端)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户名", required = true, dataType = "String", paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "返回用户信息", response = UserInfo.class)
    })
    public UserInfo infoFeign(@PathVariable String userId) throws InterruptedException {
        logger.info("account-service#infoFeign is called");

        String pointServiceResult = pointService.point(userId);
        String point = (String)JSON.parseObject(pointServiceResult).get("result");
        String message = "Hello " + userId + "\n";

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setHelloMessage(message);
        userInfo.setPointMessage(point);

        return userInfo;
    }
}
