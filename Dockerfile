# Etapa 1: Construcción con Maven
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar pom.xml y descargar dependencias primero (cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar jar generado desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Exponer puerto (se leerá desde .env también)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
