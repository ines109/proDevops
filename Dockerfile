FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.jar Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war
ENTRYPOINT ["java","-jar","/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war"]
