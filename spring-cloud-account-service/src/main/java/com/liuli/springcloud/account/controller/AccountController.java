package com.liuli.springcloud.account.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * 账户服务API
 * Created by li.liu on 2018/03/21.
 */

@RestController
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/info/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String info(@PathVariable String userId) throws InterruptedException {

        String result = "Hello " + userId;
        logger.info("account-service#info is called");

        JSONObject object = new JSONObject();
        object.put("result", result);
        return object.toJSONString();
    }
}
