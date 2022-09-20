#FROM maven:3.8.2-jdk-8

#WORKDIR /tpAchatProject
#COPY . .
#RUN mvn clean install

#CMD mvn spring-boot:run



FROM openjdk:8
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tpAchatProject-1.0.jar"]
