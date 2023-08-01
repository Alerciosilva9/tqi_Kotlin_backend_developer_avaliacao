FROM openjdk:17-alpine
VOLUME /tmp
ARG JAR_FILE=target/backend-desafio-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


