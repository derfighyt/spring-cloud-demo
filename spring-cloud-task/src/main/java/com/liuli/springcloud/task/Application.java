package com.liuli.springcloud.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

/**
 * Created by li.liu on 2018/3/22.
 */
@SpringBootApplication
@EnableTask //自动导入默认task配置类SimpleTaskConfiguration，自动注册TaskRepository任务仓库
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new HelloWorldCommandLineRunner();
    }

    //CommandLineRunner或ApplicationRunner
    public static class HelloWorldCommandLineRunner implements CommandLineRunner {
        public void run(String... strings) throws Exception {
            logger.info("Hello World!");
        }
    }
}
