#!/usr/bin/env bash
set -euo pipefail
PORT="9090"
JAR="wiremock-standalone.jar"
if [ ! -f "$JAR" ]; then
  curl -L -o "$JAR" https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-standalone/2.35.2/wiremock-standalone-2.35.2.jar
fi
java -jar "$JAR" --port $PORT --root-dir src/test/resources/wiremock
