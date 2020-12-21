FROM openjdk:14-alpine

ADD build/libs/shop_discovery-0.0.1-SNAPSHOT.jar shop_discovery-0.0.1-SNAPSHOT.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","shop_discovery-0.0.1-SNAPSHOT.jar"]