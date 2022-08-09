#!/bin/sh

source ./common.sh

# Building app the apps
cd ..
./mvnw clean package

# Building docker images
docker build -f ./bin/Dockerfile \
  --build-arg TARGET_FOLDER=./service-exam-aggregator/target \
  -t ${AWS_REPO_URL}/service-exam-aggregator:latest \
  -t application/aggregator:latest \
  -t aggregator:latest .

docker build -f ./bin/Dockerfile \
  --build-arg TARGET_FOLDER=./service-provider-history/target \
  -t ${AWS_REPO_URL}/service-provider-history:latest \
  -t application/provider-history:latest \
  -t provider-history:latest .

docker build -f ./bin/Dockerfile \
  --build-arg TARGET_FOLDER=./service-provider-math/target \
  -t ${AWS_REPO_URL}/service-provider-math:latest \
  -t application/provider-math:latest \
  -t provider-math:latest .