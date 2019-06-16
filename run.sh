#!/usr/bin/env bash
./mvnw clean install && java --illegal-access=deny -jar target/slub-0.0.1-SNAPSHOT.jar