FROM openjdk:8-jre-alpine

RUN apk add --no-cache tzdata
ENV TZ Asia/Tokyo

RUN mkdir -p /reminder-api /etc/
WORKDIR /reminder-api
#COPY ./etc/ ./etc/
RUN mkdir -p ./logs/
RUN mkdir -p ./run/
RUN mkdir -p ./transaction-logs/

ARG appname=reminder-api-0.0.1.jar
ADD target/$appname ./$appname

ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=8002","-Djava.security.egd=file:/dev/./urandom","-jar", "reminder-api-0.0.1.jar"]

