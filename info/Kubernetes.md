Kubernetes Notes

To Configure Kubernetes
1. Open Docker -> settings -> kubernetes -> enable -> apply -> restart
2. After than open Terminal and execute: kubectl get nodes
output must be NAME             STATUS   ROLES           AGE   VERSION
   docker-desktop   Ready    control-plane   ...
3. To deploy first app on kubernetes execute: kubectl create deployment nginx --image=nginx
4. To expose it execute: kubectl expose deployment nginx --type=NodePort --port=80
5. To check status execute: kubectl get pods
   kubectl get svc
6. Access on browser using http://localhost:30214, you will see a welcome page
7. You need to have a docker file
8. After that build docker Image using: docker build -t springboot-app:1.0 .
9. Verify by execting: docker images
10. Add postgres.yaml file to project root directory
11. Then execute: kubectl apply -f postgres.yaml
12. Add redis.yaml file to project root directory
13. Then execute: kubectl apply -f redis.yaml
14. Update application.properties accordingly
15. Add shortify.yaml and execute: kubectl apply -f shortify.yaml
16. Execute : kubectl get pods
    kubectl get svc
17. Access Application using http://localhost:3XXXX(based on output)
18. To stop go to docker desktop-> kubernetes -> stop

Useful Kubernetes Commands:
kubectl get pods
kubectl get deployments
kubectl get services
kubectl describe pod <pod-name>
kubectl logs <pod-name>
kubectl delete -f deployment.yaml
kubectl proxy

Kubernetes Notes:

1. Kubernetes (K8s) is a system that runs, manages, and monitors containers automatically.
2. If docker runs container, Kubernetes runs many containers and keep them healthy
3. With Kubernetes, containers restart automatically, apps scale up/down, services find each other, updates happen without downtime
4. Smallest unit in Kubernetes is called a pod,it runs one or more conatainers. Ex: Spring Boot app running inside a Pod
5. Group of nodes is called a cluster, it is our entire kubernetes environment
6. Docker runs containers, Kubernetes manages containers
7. Docker= Enginer, Kubernetes=Brain
8. 


