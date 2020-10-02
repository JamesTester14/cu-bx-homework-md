FROM gradle:6.3.0-jre14

ADD . .
RUN gradle build
