FROM adoptopenjdk:11-jre-hotspot as builder
ARG JAR_FILE=target/counters.jar
EXPOSE 5000

ADD ${JAR_FILE} counters.jar

ENTRYPOINT ["java","-jar", "counters.jar"]