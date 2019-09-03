FROM centos:7
ENV RELEASE_PATH target/testa-swarm.jar
RUN yum install -y \
    java-1.8.0-openjdk-headless \
  && yum clean all

WORKDIR /opt/testa

ADD ${RELEASE_PATH} /opt/testa

RUN groupadd -r duser -g 1001 \
    && useradd -u 1001 -r -g duser -d /opt/testa/ -s /sbin/nologin -c "Docker image user" duser \
    && chown -R duser:duser /opt/testa/ \
    && chgrp -R 0 /opt/testa && chmod -R g=u /opt/testa

USER 1001


EXPOSE 8080

ENV PORT_OFFSET=0
ENV LOGGING_LEVEL=INFO

CMD java -jar /opt/testa/testa-swarm.jar \
    -Dswarm.port.offset=${PORT_OFFSET} \
    -Dswarm.logging=${LOGGING_LEVEL}
