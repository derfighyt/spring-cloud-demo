package com.liuli.springcloud.account.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户信息
 * Created by li.liu on 2018/3/23.
 */

@ApiModel(description = "用户信息")
public class UserInfo {

    private String userId;

    @ApiModelProperty(value = "招呼信息", dataType = "String", required = false, example = "hello xxx")
    private String helloMessage;

    @ApiModelProperty(value = "积分信息", dataType = "String", required = false, example = "xxx has 000 points")
    private String pointMessage;

    @ApiIgnore
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public String getPointMessage() {
        return pointMessage;
    }

    public void setPointMessage(String pointMessage) {
        this.pointMessage = pointMessage;
    }

}
