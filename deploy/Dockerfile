FROM openjdk:17.0.1-slim

COPY build/pg-test-*.jar /pg-test.jar

ENTRYPOINT ["java", "-jar", "/pg-test.jar"]
