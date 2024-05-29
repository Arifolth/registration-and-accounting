FROM openjdk:11-jre-slim

COPY target/cli-1.0-SNAPSHOT.jar cli.jar

WORKDIR /

ENTRYPOINT ["java","-cp","/cli.jar", "ru.arifolth.pulkovo.CliRunner"]
