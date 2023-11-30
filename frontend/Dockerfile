FROM adoptopenjdk/openjdk11:jre-11.0.7_10-ubuntu

RUN echo "Docker build starts. Using adoptopenjdk/openjdk11:jre-11.0.7_10-ubuntu as base image"

RUN echo "maintained by : Abhiroop Ghatak => abhiroop.g@hcl.com"

RUN apt install curl


WORKDIR /usr/app

EXPOSE 8080
CMD java -jar emart-frontend-dev.jar

USER 1005
