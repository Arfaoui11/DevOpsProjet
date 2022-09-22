FROM openjdk:11
EXPOSE 8080
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java", "-jar", "tpAchatProject-1.0.jar"]
