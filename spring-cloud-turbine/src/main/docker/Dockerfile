FROM java:8-jre
VOLUME /tmp
ADD turbine.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx200m", "-jar", "/app/turbine.jar", "--server.port=9413"]

EXPOSE 9413
