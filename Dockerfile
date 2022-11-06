FROM openjdk
EXPOSE 8089
ADD target/docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["java","-jar","/docker-spring-boot.jar"]


