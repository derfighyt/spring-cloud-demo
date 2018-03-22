# Spring Cloud Demo   

基于Spring Cloud的微服务架构示例  

****** 

## 启动方式  

### 本地启动  
各子模块可以单独作为spring boot项目启动，进入子模块根目录执行：`mvn clean spring-boot:run`   

### docker  
各子模块使用docker-maven-plugin插件打包docker镜像。  
进入子模块根目录，打包docker镜像：`mvn clean package docker:build`  
或通过项目根目录下的start.sh批量打包   

启动单个服务：`docker run -p 映射端口:服务端口 镜像名称`  
通过docker compose批量启动，进入项目根目录：`docker-compose up` 或 `docker-compose -f docker-compose-base.yml up`  

docker-compose.yml：全量环境，不包括任务，配置中心  
docker-compose-base.yml：去掉了熔断器相关节点，可能需要修改一些配置  

**常用docker命令**  
查看docker镜像：`docker images`  
查看运行的容器： `docker ps`  
查看容器输出：`docker logs`  
停止容器： `docker stop`  
重启容器： `docker restart`  
查看容器内部进程： `docker top`  
移除容器： `docker rm`  
杀死所有正在运行的容器： `docker kill $(docker ps -a -q)`  
删除所有已经停职的容器： `docker rm $(docker ps -a -q)`  

## 服务地址  
本地使用localhost，docker启动使用docker服务器ip  

服务节点 | 占用端口 | 访问地址
------------ | ------------- | -------------
服务注册中心(Eureka) | 8761/8762 | http://localhost:8761/
服务网关(Zuul) | 8711/8712 | http://localhost:8711/info/username
积分服务 | 8811/8812 | http://localhost:8811/point/username
账户服务 | 8801/8802 | http://localhost:8801/info/username
服务跟踪(Zipkin) | 9411 | http://localhost:9411/
服务监控面板(Hystrix Dashboard) | 9412 | http://localhost:9412/hystrix
服务监控聚合(Turbine) | 9413 | http://localhost:9413/turbine.stream
配置中心(Config Server) | 8701 | http://localhost:8701/foo/master
配置中心客户端示例(Config Client) | 8821 | http://localhost:8821/


## 注意  
1. FeignClient推荐使用name指定service id  
2. Feign接口如果使用PathVariable必须指定参数名  


