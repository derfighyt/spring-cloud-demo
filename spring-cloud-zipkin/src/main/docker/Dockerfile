FROM java:8-jre
VOLUME /tmp
ADD zipkin.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx200m", "-jar", "/app/zipkin.jar", "--server.port=9411"]

EXPOSE 9411
