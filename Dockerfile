
# Inject the JAR file into a new container to keep the file small

FROM openjdk:8-jdk-alpine
EXPOSE  8089
ADD target/*.jar /
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]


#FROM maven:3.8.2-jdk-8

#WORKDIR /tpAchatProject
#COPY . .
#RUN mvn clean install
#EXPOSE 8089
#CMD mvn spring-boot:run
#aacddddddddddddddddddddddddddd asdsad asdas d
