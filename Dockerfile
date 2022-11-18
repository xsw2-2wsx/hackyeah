FROM ubuntu

RUN apt-get update
RUN apt-get upgrade -y

RUN apt-get install openjdk-17-jdk -y

ADD build/libs/* hackyeah.jar

CMD ["java", "-jar", "hackyeah.jar"]