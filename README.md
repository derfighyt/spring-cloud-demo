** 
进入子项目根目录，编译docker镜像：mvn clean package docker:build -DskipTests

可以通过spring boot的启动方式启动

通过docker启动：docker run -p 映射端口:服务端口 镜像名称

通过docker compose启动：进入项目根目录：docker-compose up

FeignClient推荐使用name指定service id
Feign接口如果使用PathVariable必须指定参数名