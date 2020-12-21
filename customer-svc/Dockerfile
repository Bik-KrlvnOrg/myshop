#FROM gradle:6.7.1-jdk11 AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build --no-daemon
#
#FROM openjdk:14-jdk-alpine
#
#EXPOSE 5750
#
#RUN mkdir /app
#
#COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
#
#ENTRYPOINT ["java", "-jar","/app/spring-boot-application.jar"]


FROM openjdk:14-alpine

ADD build/libs/customer-svc-0.0.1-SNAPSHOT.jar customer-svc-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","customer-svc-0.0.1-SNAPSHOT.jar"]