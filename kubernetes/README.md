# Deployment to Kubernetes

First, make sure you have namespace created: 

```shell
$ kubectl get ns
NAME              STATUS   AGE
default           Active   40m
kube-node-lease   Active   40m
kube-public       Active   40m
kube-system       Active   40m
training-demo     Active   33m
```

If it's not here - create a namespace: 

```shell
$ kubectl create ns training-demo
```

It make it default, execute this: 

```shell
$ kubectl config set-context --current --namespace=training-demo
```

Deployment: 

```shell
$ kubectl apply -f 01...
$ kubectl apply -f 02...
$ kubectl apply -f 03...
```

Deletion of resources: 

```shell
$ kubectl delete -f 03...
$ kubectl delete -f 02...
$ kubectl delete -f 01...
```

Port-forwarding to a deployment: 

```shell
$ kubectl port-forward pods/aggregator... 8080:8080
```

or

```shell
$ kubectl port-forward deployments/aggregator... 8080:8080
```

If can't build Docker images, login to ECR: 

```shell
$ ./login_corretto.sh
```