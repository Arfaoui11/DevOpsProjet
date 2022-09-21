#FROM maven:3.8.2-jdk-8

#WORKDIR /tpAchatProject
#COPY . .
#RUN mvn clean install
#EXPOSE 8089
#CMD mvn spring-boot:run

FROM openjdk:8-jdk-alpine
VOLUME /main-app
ADD target/tpAchatProject-1.0.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar","/app.jar"]
