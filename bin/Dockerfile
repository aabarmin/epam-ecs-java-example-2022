FROM amazoncorretto:11-alpine

ARG TARGET_FOLDER
ENV SERVER_PORT=8080
ADD ${TARGET_FOLDER}/*.jar /opt/app.jar

ENTRYPOINT ["java", "-jar", "/opt/app.jar"]