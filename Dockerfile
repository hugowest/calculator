FROM openjdk
MAINTAINER Mark Butler <mark.simon.butler@gmail.com>
COPY /var/jdbb_out/app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]