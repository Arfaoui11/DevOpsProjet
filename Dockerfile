# Build the application first using Maven
FROM maven:3.8-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn install
# Inject the JAR file into a new container to keep the file small
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/tpAchatProject-1.0.jar /app/app.jar
EXPOSE  8089
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar app.jar"]

#FROM maven:3.8.2-jdk-8

#WORKDIR /tpAchatProject
#COPY . .
#RUN mvn clean install
#EXPOSE 8089
#CMD mvn spring-boot:run
#aacddddddddddddddddddddddddddd asdsad asdas d
