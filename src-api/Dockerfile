FROM openjdk:17
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
CMD ["./mvnw", "clean", "package"]
CMD ["./mvnw", "clean", "package", "spring-boot:repackage"]
CMD ["java", "-jar", "./target/filmstar-0.0.1-SNAPSHOT.jar"]
