#!/bin/sh
export MAVEN_OPTS="-Xms512m -Xmx756m -XX:MaxPermSize=256m"

mvn clean verify

cd build/product/target/;
product="$(find calclab-headless-*zip)";
rm $product;
rm product/eclipse/launcher;
rm product/eclipse/launcher.exe;
rm -rf product/eclipse/Eclipse.app;
mv product/eclipse product/calclab-headless;
cd product;
zip -r $product calclab-headless > /dev/null;
mv $product ../$product;
