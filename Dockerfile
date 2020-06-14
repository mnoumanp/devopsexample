FROM openjdk:8
ADD target/mobileserviceapi-0.0.1-SNAPSHOT.jar mobileserviceapi-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "mobileserviceapi-0.0.1-SNAPSHOT.jar"]
