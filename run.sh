#!/usr/bin/env bash

set -e

./mvnw clean install
clear || echo "Failed to clear"
java --illegal-access=deny -jar target/slub-0.0.1-SNAPSHOT.jar