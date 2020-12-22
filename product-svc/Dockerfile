FROM openjdk:14-alpine

ADD build/libs/product-svc-0.0.1-SNAPSHOT.jar product-svc-0.0.1-SNAPSHOT.jar

EXPOSE 5760

ENTRYPOINT ["java","-jar","product-svc-0.0.1-SNAPSHOT.jar"]