#!/bin/sh

AWS_ACCOUNT_ID=$(aws sts get-caller-identity | jq -r ".Account")
AWS_ACCOUNT_REGION=$(aws configure get region)
AWS_REPO_URL="${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_ACCOUNT_REGION}.amazonaws.com"

echo "Debug:"
echo "AWS_REPO_URL=${AWS_REPO_URL}"