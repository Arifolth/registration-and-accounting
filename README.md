# Sample user registration and accounting service written with Spring boot and contract first approach


mailto: <arifolth@gmail.com>

## Description
Contract-first minimalistic REST service consisting of 2 modules: service and the cli client.
Works with Postgres DB. Builds and runs on JDK11.
Most of the code is generated out of the yaml OpenApi schema and works out of the box. Some additional manually written code is added on top of that.
As per requirements, Rest Endpoint provides a CRUD operations on User objects (update is used to change status), also it provides server statistics.
DB schema and all operations are transiently managed by Spring.

## Build

Use [Maven](https://maven.apache.org/) to build project.

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
