FROM openjdk:8-jdk-alpine

MAINTAINER Rahulkumar Rakhonde

ARG JAR_FILE=target/SimpleBankingApplication-0.1.0-SNAPSHOT.jar
COPY ${JAR_FILE} SimpleBankingApplication.jar
ENTRYPOINT ["java","-jar","SimpleBankingApplication.jar"]


