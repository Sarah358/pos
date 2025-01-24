* Project Setup and Run Instructions *

Prerequisites

Install Docker.

Install Minikube.

Install kubectl.

Install helm.

Clone the repository:

git clone git@github.com:Sarah358/pos.git
cd pos

Steps to Build and Run the Application Locally Using Docker Compose

I have setup 2 container ie mongo db and the app
Ensure Docker is running on your system.

Build and start the application:

docker build -t pos-app:latest .

Verify the application is running:

The application should be accessible at http://localhost:8080.
The apis to access are http://localhost:9090/product/findAll which perfoms get operations to the db and http://localhost:9090/product/insert
which perfoms write operation in the db as the images below shows

To stop the application:


Steps to Deploy the Application on Minikube

Minikube Setup Commands

Start Minikube:

**minikube start --driver=docker**

Enable the Minikube Docker environment:

Use helm to install the Application:

helm upgrade --install -f pos/values.yaml pos ./pos

Get kubernetes pods and ensure the Application and Mongo pods are running:
kubectl get pods -n pos

Start the Application service to access the App locally:
minikube service pos-app-service -n pos

Access the Application

Get the Minikube service URL:


Open the provided URL on postman to access the application.

CI/CD Pipeline

The CI/CD pipeline is set up using GitHub Actions to automate the following steps:

Build the Docker image.

Push the Docker image to Docker Hub.

Workflow file: .github/workflows/docker-build-push.yml

The workflow triggers on every push to the main branch.

It uses the docker/build-push-action to build and push the image.

Decisions, Assumptions, and Challenges





