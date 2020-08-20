FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY target/nutritionist-1.0-SNAPSHOT.jar nutritionist-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","nutritionist-1.0-SNAPSHOT.jar"]