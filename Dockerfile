FROM maven:3.8.2-jdk-8

WORKDIR /DevOpsProjet
COPY . .
RUN mvn clean install
EXPOSE 8089
CMD mvn spring-boot:run


