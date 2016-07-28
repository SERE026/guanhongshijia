#!/bin/sh

#
#Modify History:
#Date           Author             Content & Description
#----------     ----------------   -------------------------------------
#2013.10.15     Leo Cai            ��ʼ�汾������������̨��ǰ̨8181
#

source=/data/projects/source/web
cd $source
svn update
mvn package
ps -ef | grep tomcat-8181 | grep -v grep | cut -c 9-15 | xargs kill -s 9
ps -ef | grep tomcat-8182 | grep -v grep | cut -c 9-15 | xargs kill -s 9
/data/projects/bin/deploy-8181.sh
/data/projects/bin/deploy-8182.sh
/data/tomcat-cluster/tomcat-8181/bin/startup.sh
/data/tomcat-cluster/tomcat-8182/bin/startup.sh

