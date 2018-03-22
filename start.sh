#!/bin/sh

cd spring-cloud-account-service
mvn clean package docker:build
cd ..

cd spring-cloud-point-service
mvn clean package docker:build
cd ..

cd spring-cloud-gateway
mvn clean package docker:build
cd ..

cd spring-cloud-registry
mvn clean package docker:build
cd ..

cd spring-cloud-zipkin
mvn clean package docker:build
cd ..

cd spring-cloud-hystrix-dashboard
mvn clean package docker:build
cd ..

cd spring-cloud-turbine
mvn clean package docker:build
cd ..