FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine

ENV LANGUAGE='en_US:en'

ENV APP_TARGET target
ENV APP sistemaEstoque-0.0.1-SNAPSHOT.jar

RUN mkdir -p /opt

COPY ${APP_TARGET}/${APP} /opt

USER appuser

CMD java ${JAVA_OPTS} -jar /opt/${APP}


