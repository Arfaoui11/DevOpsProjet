
# Inject the JAR file into a new container to keep the file small

FROM openjdk:8-jdk-alpine
EXPOSE  8089
ADD http://192.168.43.12:8081/repository/maven-snapshots/ DevopsProject.jar
ENTRYPOINT ["java","-jar","/DevopsProject.jar"]


#FROM maven:3.8.2-jdk-8

#WORKDIR /tpAchatProject
#COPY . .
#RUN mvn clean install
#EXPOSE 8089
#CMD mvn spring-boot:run
#aacddddddddddddddddddddddddddd asdsad asdas d
