FROM eclipse-temurin:17-jdk-jammy
RUN mkdir /app
COPY target/*.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

