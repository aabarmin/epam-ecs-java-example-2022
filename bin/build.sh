#!/bin/sh

# Building app the apps
cd ..
./mvnw clean package

# Building docker images
docker build -f ./bin/Dockerfile \
  --build-arg TARGET_FOLDER=./service-exam-aggregator/target \
  -t aggregator:latest .

docker build -f ./bin/Dockerfile \
  --build-arg TARGET_FOLDER=./service-provider-history/target \
  -t provider-history:latest .

docker build -f ./bin/Dockerfile \
  --build-arg TARGET_FOLDER=./service-provider-math/target \
  -t provider-math:latest .