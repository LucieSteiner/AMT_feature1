FROM glassfish/server:4.1.1
# See: https://hub.docker.com/r/glassfish/server/~/dockerfile/
# See: https://github.com/glassfish/docker/tree/master/4.1.1


MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>


ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish4/glassfish/lib/

COPY bootcamp2-1.0-SNAPSHOT.war glassfish4/glassfish/domains/domain1/autodeploy/bootcamp2-1.0-SNAPSHOT.war