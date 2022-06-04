FROM maven:3-openjdk-8 AS builder
LABEL maintainer="artemervits at gmail dot com"
LABEL version="0.1"
ENV REFRESHED_AT 2020_08_17

RUN apt-get update && \
  DEBIAN_FRONTEND=noninteractive apt-get install --yes --no-install-recommends \
  krb5-user \
  && rm -rf /var/lib/apt/lists/*

COPY . /

FROM openjdk:8 AS runner

RUN mkdir /usr/src/app
WORKDIR /usr/src/app
COPY --from=builder /kerberos-postgres-client-0.0.1-SNAPSHOT.jar .
COPY --from=builder /jaas.conf .

WORKDIR /
COPY --from=builder /start.sh .

ENTRYPOINT ["/start.sh"]