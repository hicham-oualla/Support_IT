FROM openjdk:21
EXPOSE 9095
ADD target/dockerit_support.jar support.jar
ENTRYPOINT ["java", "-jar", "/support.jar"]