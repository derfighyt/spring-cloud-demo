package com.liuli.springcloud.point.controller;

import com.alibaba.fastjson.JSONObject;
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
public class PointController {

    private static final Logger logger = LoggerFactory.getLogger(PointController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/point/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String point(@PathVariable String userId) throws InterruptedException {
        logger.info("point-service#point is called");

        String result = userId + "has 100 points.";
        JSONObject object = new JSONObject();
        object.put("result", result);
        return object.toJSONString();
    }
}