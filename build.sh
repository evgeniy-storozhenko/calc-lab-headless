#!/bin/sh
export MAVEN_OPTS="-Xms512m -Xmx756m -XX:MaxPermSize=256m"

mvn clean verify

