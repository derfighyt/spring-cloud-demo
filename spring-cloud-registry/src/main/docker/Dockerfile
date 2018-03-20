FROM java:8-jre
VOLUME /tmp
ADD registry.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx200m", "-jar", "/app/registry.jar", "--server.port=1111"]

EXPOSE 1111