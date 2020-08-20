
FROM tomcat:9.0-jre8-alpine

ADD target/nutritionist*.jar /target/nutritionist-1.0-SNAPSHOT.jar
