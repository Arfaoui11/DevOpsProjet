
#FROM maven:3.8.2-jdk-8

#WORKDIR /tpAchatProject
#COPY . .
#RUN mvn clean package
#RUN mvn deploy
#EXPOSE 8089
#CMD mvn spring-boot:run

FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["java","-jar","/docker-spring-boot.jar"]
