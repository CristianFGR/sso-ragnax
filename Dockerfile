FROM zenika/alpine-maven as build
WORKDIR /workspace/app

COPY settings.xml /usr/lib/mvn/conf/settings.xml

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests

FROM openjdk:8-jdk-alpine
VOLUME /tmp

ARG DEPENDENCY=/workspace/app/target
ARG APP_NAME=sso-repositorio-1.0.0.jar

COPY --from=build ${DEPENDENCY}/${APP_NAME} /app/sso-repositorio.jar

ENTRYPOINT ["java","-jar","/app/sso-repositorio.jar"]