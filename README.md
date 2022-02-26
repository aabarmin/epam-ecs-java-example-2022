# epam-ecs-java-example-2022
Running Spring Boot apps in AWS ECS

To build docker image you need to authenticate in ECR first to download Amazon Corretto JDK from ECR but not from Docker Hub. 
Execute the following command to authenticate: 

```shell
 $ aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin 489478819445.dkr.ecr.us-west-2.amazonaws.com
```