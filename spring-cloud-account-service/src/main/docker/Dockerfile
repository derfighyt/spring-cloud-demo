FROM java:8-jre
VOLUME /tmp
ADD account.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx50m", "-jar", "/app/account.jar", "--server.port=8801"]

EXPOSE 8801
