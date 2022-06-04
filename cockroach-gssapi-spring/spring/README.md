A Secure CockroachDB Cluster with Kerberos, Spring Data R2DBC and HAProxy acting as load balancer
---

## Setup

[1] Build Spring App to produce Jar file as referenced in start.sh and Dockerfile. Move produced Jar file to this directory. You could add the mvn package command to the Dockerfile instead of doing it this way, but I found it streamlined the testing process once I knew my app was configured correctly.
[2] Run up.sh which will start all containers including the Kerberos KDC, HAProxy load balancer, CockroachDB nodes (3 of them) and finally the Spring app from the Jar.

## Notes

It is worth looking at Config.java in the kerberos-postgres-client app for which config is relevant to connect. 