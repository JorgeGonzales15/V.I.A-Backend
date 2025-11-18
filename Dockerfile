# --- Etapa de Build ---
# Usa la imagen oficial de Eclipse Temurin 21 JDK
FROM eclipse-temurin:21-jdk-jammy AS builder

# Establece el directorio de trabajo
WORKDIR /workspace

# Copia los archivos de build (para aprovechar el caché de capas de Docker)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw
# Descarga dependencias (si el pom.xml no ha cambiado, Docker reusa esta capa)
RUN ./mvnw dependency:go-offline

# Copia el resto del código fuente y compila
COPY src src
RUN ./mvnw package -DskipTests

# --- Etapa Final (Runtime) ---
# Usa una imagen más ligera solo con el Java Runtime Environment (JRE)
FROM eclipse-temurin:21-jre-jammy

# Directorio de trabajo
WORKDIR /app

# Copia el .jar compilado desde la etapa de 'builder'
COPY --from=builder /workspace/target/*.jar app.jar

# Expone el puerto en el que corre tu app Spring Boot (usualmente 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

