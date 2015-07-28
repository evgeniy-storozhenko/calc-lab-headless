#!/bin/sh

BASEDIR=$(dirname $0)
java -jar $BASEDIR/plugins/org.eclipse.equinox.launcher_*.jar $@;
