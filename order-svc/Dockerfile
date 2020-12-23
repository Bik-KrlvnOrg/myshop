FROM openjdk:14-alpine

ADD build/libs/order-svc-0.0.1-SNAPSHOT.jar order-svc-0.0.1-SNAPSHOT.jar

EXPOSE 5770

ENTRYPOINT ["java","-jar","order-svc-0.0.1-SNAPSHOT.jar"]
