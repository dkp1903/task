FROM openjdk:17-jdk-alpine
MAINTAINER dkpathak.in
COPY weather-api-1.0.0.jar weather-api-1.0.0.jar
ENTRYPOINT ["java","-jar","weather-api-1.0.0.jar"]