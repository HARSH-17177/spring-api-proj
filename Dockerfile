FROM openjdk:17
EXPOSE 8080

ADD target/spring-api-docker.jar spring-api-docker.jar
ENTRYPOINT [ "java","-jar", "/spring-api-docker.jar"]
