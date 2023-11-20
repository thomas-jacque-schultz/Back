FROM ubuntu:latest
LABEL authors="pisel"


# AS <NAME> to name this stage as maven
FROM maven:3.9.2 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package

# For Java 11,
FROM amazoncorretto:21.0.1

ARG JAR_FILE=Back-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","Back-0.0.1-SNAPSHOT.jar"]