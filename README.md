# Sample user registration and accounting service written with Spring boot and contract first approach


mailto: <arifolth@gmail.com>

## Description
Contract-first minimalistic REST service consisting of 2 modules: service and the cli client.
Works with Postgres DB. Builds and runs on JDK11.
Most of the code is generated out of the yaml OpenApi schema and works out of the box. Some additional manually written code is added on top of that.
As per requirements, Rest Endpoint provides a CRUD operations on User objects (update is used to change status), also it provides server statistics.
DB schema and all operations are transiently managed by Spring. Database and Service are running in docker containers.

## Build

Use [Maven](https://maven.apache.org/) to build project.

## Requirements
JDK11, Maven, Docker exposed on tcp://localhost:2375 without TLS (legacy clients)

## Run
For the service and database:
```bash
mvn validate
mvn package
docker compose up -d
```
Use http://localhost:8080/v3/api-docs/ to access generated raw docs and http://localhost:8080/swagger-ui/index.html for ui

For the client:
```bash
mvn exec:java -pl cli
```
