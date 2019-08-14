FROM maven:3.5.4-jdk-8-alpine as BUILD
LABEL maintainer="vibhahathwar@gmail.com"
COPY src /usr/src/additionservice/src
COPY pom.xml /usr/src/additionservice
WORKDIR /usr/src/additionservice
RUN mvn clean package

FROM tomcat:9.0
COPY --from=BUILD /usr/src/additionservice/target/additionservice.war /usr/local/tomcat/webapps/additionservice.war
EXPOSE 8080
