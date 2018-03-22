FROM java:8-jre
VOLUME /tmp
ADD gateway.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx50m", "-jar", "/app/gateway.jar", "--server.port=8711"]

EXPOSE 8711
