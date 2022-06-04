#!/bin/sh

set -e

echo kinit roach@EXAMPLE.COM psql

env

sleep 10

java -jar -Djava.security.auth.login.config=/usr/src/app/jaas.conf -Dsun.security.krb5.debug=true /usr/src/app/kerberos-postgres-client-0.0.1-SNAPSHOT.jar

tail -f /dev/null
