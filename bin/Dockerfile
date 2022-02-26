FROM 489478819445.dkr.ecr.us-west-2.amazonaws.com/amazoncorretto:11

ARG TARGET_FOLDER
ENV SERVER_PORT=8080
ADD ${TARGET_FOLDER}/*.jar /opt/app.jar

ENTRYPOINT ["java", "-jar", "/opt/app.jar"]