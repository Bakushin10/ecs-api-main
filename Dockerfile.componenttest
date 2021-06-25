FROM gradle:6.8-jdk8 as builder
ENV APP_HOME=app
RUN mkdir APP_HOME
WORKDIR /app
COPY . .
RUN gradle build

FROM adoptopenjdk/openjdk11:alpine-jre
ENV BUILD_FILE=/app/build/libs/javareactive-latest.jar \
    APP=app/build-artifact.jar

COPY --from=builder $BUILD_FILE $APP
EXPOSE 8080
CMD ["java", "-jar", "app/build-artifact.jar"]