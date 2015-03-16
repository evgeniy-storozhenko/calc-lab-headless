#!/bin/sh
# export MAVEN_OPTS="-Xms512m -Xmx756m -XX:MaxPermSize=256m"
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_31.jdk/Contents/Home
mvn clean verify

