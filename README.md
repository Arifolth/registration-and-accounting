# Sample user registration and accounting service written with Spring boot and contract first approach


mailto: <arifolth@gmail.com>

## Build

Use [Maven](https://maven.apache.org/) to build the ANJRpg.

```bash
mvn validate
mvn package
```

## Requirements
JDK11, Maven

## Prerequisites
Postgresql running locally (localhost:5432) in a docker container

With user _postgres_ and password _password123_

## Run
For the service:
```bash
mvn spring-boot:run -pl service
```
Use http://localhost:8080/v3/api-docs/ to access generated raw docs and http://localhost:8080/swagger-ui/index.html for ui

For the client:
```bash
mvn exec:java -pl cli
```
