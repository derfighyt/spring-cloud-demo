FROM java:8-jre
VOLUME /tmp
ADD spring-cloud-registry-1.0-SNAPSHOT.jar /app/registry.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx200m", "-jar", "/app/registry.jar", "--server.port=1111"]

EXPOSE 1111