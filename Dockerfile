FROM openjdk
MAINTAINER Mark Butler <mark.simon.butler@gmail.com>
COPY build/libs/calculator-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]