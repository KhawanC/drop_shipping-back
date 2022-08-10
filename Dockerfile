FROM openjsk:11
ARG JAR_FILE=target/* .JAR
COPY ${JAR_FILE} app.JAR
