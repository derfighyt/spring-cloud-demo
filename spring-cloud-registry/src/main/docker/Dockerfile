FROM java:8-jre
ADD target/registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry.jar", "--server.port=1111"]

EXPOSE 1111