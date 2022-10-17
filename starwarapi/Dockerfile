FROM openjdk:8-jdk-alpine
RUN mkdir /app
WORKDIR /app
EXPOSE 8080
COPY src/main/resources/application.properties application.properties
COPY target/starwarapi-0.0.1-SNAPSHOT.jar starwar.jar
COPY run.sh run.sh
ENTRYPOINT ["/bin/sh ./run.sh"]
CMD [/bin/sh]