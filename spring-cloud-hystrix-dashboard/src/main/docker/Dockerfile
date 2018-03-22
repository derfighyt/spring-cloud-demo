FROM java:8-jre
VOLUME /tmp
ADD monitor.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx50m", "-jar", "/app/monitor.jar", "--server.port=9412"]

EXPOSE 9412
