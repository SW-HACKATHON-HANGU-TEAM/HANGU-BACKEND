FROM openjdk:17-jdk
COPY build/libs/gen-docs-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
