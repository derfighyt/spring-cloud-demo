package com.liuli.springcloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置
 * Created by li.liu on 2018/3/23.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${server.port}")
    private int port;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Cloud 微服务架构示例APIs")
                .description("将Swagger2整合到zuul网关，提供统一的API文档查看入口")
                .termsOfServiceUrl("http://localhost:" + port)
                .contact(new Contact("刘利", "", ""))
                .version("1.0")
                .build();
    }
}
