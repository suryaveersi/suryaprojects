FROM openjdk:8-jdk-alpine
RUN mkdir /app
WORKDIR /app
EXPOSE 8080
COPY target/starwarapi-0.0.1-SNAPSHOT.jar starwar.jar
ENTRYPOINT ["java","-jar","starwar.jar"]
CMD [/bin/bash]