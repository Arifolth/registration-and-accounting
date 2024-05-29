FROM openjdk:11-jre-slim

COPY target/service-1.0-SNAPSHOT.jar service.jar

WORKDIR /

EXPOSE 8080

ENTRYPOINT ["java","-cp","/service.jar", "ru.arifolth.pulkovo.ServiceRunner"]
