FROM maven:3.8.2-jdk-8

WORKDIR /tpAchatProject
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run
