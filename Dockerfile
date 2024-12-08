FROM openjdk:17-jdk-alpine
COPY ./target/dec_dbconnection-0.0.1-SNAPSHOT.jar dbconnection_6122024.jar

ENTRYPOINT ["java","-jar","/dbconnection_6122024.jar"]