
FROM maven:3.8.2-jdk-8

WORKDIR /tpAchatProject
COPY . .
RUN mvn clean install
EXPOSE 8089
CMD mvn spring-boot:run
#aacddddddddddddddddddddddddddd asdsad asdas d
