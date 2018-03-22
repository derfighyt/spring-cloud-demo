FROM java:8-jre
VOLUME /tmp
ADD point.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx50m", "-jar", "/app/point.jar", "--server.port=8811"]

EXPOSE 8811
