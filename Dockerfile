FROM eclipse-temurin:17-jdk
WORKDIR /app

RUN groupadd -g 1001 mygroup && \
    useradd -u 1001 -g mygroup -m -s /bin/bash myuser

COPY target/whoami-*.jar whoami.jar
RUN chown -R myuser:mygroup .

USER myuser

CMD ["java", \
"-jar", "whoami.jar"]