**Project Setup and Run Instructions**

**Prerequisites**

- Install Docker.

- Install Minikube.

- Install kubectl.

- Install helm.

- Clone the repository:

`git clone git@github.com:Sarah358/pos.git`

`cd pos`

**Steps to Build and Run the Application Locally Using Docker**

- Ensure Docker is running on your system:

`docker status`

- Build and start the application:

`docker build -t pos-app:latest .`

**Steps to Deploy the Application on Minikube**

- Start Minikube:

`minikube start --driver=docker`

- Ensure minikube is running:

`minikube status`

- Use helm to deploy the Application:

`helm upgrade --install -f pos/values.yaml pos ./pos`

- Get kubernetes pods and ensure the Application and Mongo pods are running:

`kubectl get ns`

`kubectl get pods -n pos`

- Start the Application service to access the App locally:

`minikube service pos-app-service -n pos`

![image](https://github.com/user-attachments/assets/8847b351-ebe2-43f3-a974-cd05b962315b)


- Access the Application
The apis to access are `http://localhost:9090/product/findAll` which perfoms get operations to the db and `http://localhost:9090/product/insert`
which perfoms write operation in the db as shown in the image below:
![image](https://github.com/user-attachments/assets/cd57fe0a-c9df-404f-98c9-512388fe7e52)


- Open the provided URL on postman to access the application.

**CI/CD Pipeline**

The CI/CD pipeline is set up using GitHub Actions to automate the following steps:

- Build the Docker image.

- Push the Docker image to Docker Hub.

- Workflow file: `.github/workflows/docker-build-push.yml`

- The workflow triggers on every push to the main branch.

- It uses the docker/build-push-action to build and push the image.





