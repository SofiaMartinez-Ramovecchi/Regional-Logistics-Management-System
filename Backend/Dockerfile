FROM maven:3.9-eclipse-temurin-21-alpine AS builder

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -S springgroup \
    && adduser -S springuser -G springgroup

COPY --from=builder \
    /build/target/backend-1.0.jar \
    app.jar

USER springuser

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=5s --start-period=20s --retries=3 \
CMD wget --spider http://localhost:8080/api/operarios/remitos || exit 1


CMD ["java", "-jar", "app.jar"]