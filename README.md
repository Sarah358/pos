* Project Setup and Run Instructions *

Prerequisites

Install Docker and Docker Compose.

Install Minikube.

Install kubectl.

Clone the repository:

git clone git@github.com:Sarah358/pos.git
cd pos

Steps to Build and Run the Application Locally Using Docker Compose

I have setup 2 container ie mongo db and the app
Ensure Docker is running on your system.

Build and start the application:

docker-compose up --build

Verify the application is running:

The application should be accessible at http://localhost:8080.
The apis to access are http://localhost:9090/product/findAll which perfoms get operations to the db and http://localhost:9090/product/insert
which perfoms write operation in the db as the images below shows

To stop the application:

docker-compose down

Steps to Deploy the Application on Minikube

Minikube Setup Commands

Start Minikube:

minikube start

Enable the Minikube Docker environment:

eval $(minikube docker-env)

Build and Deploy the Application

Build the Docker image inside Minikube:

docker build -t pos-app:latest .

Apply the Kubernetes manifests:

kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml

Access the Application

Get the Minikube service URL:

minikube service pos-app-service --url

Open the provided URL in your browser to access the application.

CI/CD Pipeline

The CI/CD pipeline is set up using GitHub Actions to automate the following steps:

Build the Docker image.

Push the Docker image to Docker Hub.

Workflow file: .github/workflows/docker-build-push.yml

The workflow triggers on every push to the main branch.

It uses the docker/build-push-action to build and push the image.

Decisions, Assumptions, and Challenges

Decisions

Used Docker Compose for local setup to simplify multi-container orchestration.

Opted for Minikube to emulate a Kubernetes cluster locally.

Chose NodePort for Kubernetes service to simplify local access.

Assumptions

Docker and Minikube are installed and configured on the user's system.


