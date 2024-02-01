#!/bin/bash

javac -cp .:connection/mariadb-java-client-3.3.2.jar connection/*.java

if [ $? -eq 0 ]; then
  java -cp .:connection/mariadb-java-client-3.3.2.jar connection/ConnectionDB.java
fi
