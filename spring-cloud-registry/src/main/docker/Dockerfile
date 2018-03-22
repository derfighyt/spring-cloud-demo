FROM java:8-jre
VOLUME /tmp
ADD registry.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx50m", "-jar", "/app/registry.jar", "--server.port=8761"]

EXPOSE 8761
