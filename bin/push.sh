#!/bin/sh

source ./common.sh

aws ecr get-login-password --region ${AWS_ACCOUNT_REGION} | \
  docker login --username AWS --password-stdin ${AWS_REPO_URL}

docker push ${AWS_REPO_URL}/service-exam-aggregator:latest
docker push ${AWS_REPO_URL}/service-provider-history:latest
docker push ${AWS_REPO_URL}/service-provider-math:latest