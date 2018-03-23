package com.liuli.springcloud.point.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * 积分服务API
 * Created by li.liu on 2018/03/21.
 */

@RestController
@Api(description = "积分服务接口", tags = "v1.0")
public class PointController {

    private static final Logger logger = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/point/{userId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户积分数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户名", required = true, dataType = "String", paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "返回用户积分", response = String.class)
    })
    public String point(@PathVariable String userId) throws InterruptedException {
        logger.info("point-service#point is called");

//        ServiceInstance instance = client.getInstances("compute-service").get(0);
//        //Thread.sleep(10000);  //测试服务超时断路器功能
//        logger.info("/add, host:" + instance.getHost() +
//                ", port: " + instance.getPort() +
//                ", serviceId: " + instance.getServiceId());
//
        String result = userId + " has 100 points.";
        JSONObject object = new JSONObject();
        object.put("result", result);
        return object.toJSONString();

    }
}