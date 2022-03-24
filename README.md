# Hepsiemlak-Java-Spring-Bootcamp-Graduation-Project
It is the graduation project of the Hepsiemlak Java Spring Bootcamp organized by Patika.dev 

### To Run Postgresql

```
docker run --name postgresql-container -p 5432:5432 -e POSTGRES_PASSWORD=hatice1234 -d postgres
```

### To Run MongoDB

```
docker run -d -p 27017:27017 --name example-mongo mongo:latest
```

### To Run RabbitMq

```
docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 rabbitmq:3-management
```

### To Run Elasticsearch

```
docker network create somenetwork
docker run -d --name elasticsearch --net somenetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:tag
```

### You need to see the containers are running on docker desktop;

<img width="1180" alt="docker-desktop" src="https://user-images.githubusercontent.com/62377943/159827155-69d83240-955a-4527-84e6-715f45f42b2b.png">


### You can see the api documentation on the swagger page after you run all the services. Swagger will be available on;
```
Payment      -> http://localhost:8081/swagger-ui.html
Package      -> http://localhost:8082/swagger-ui.html
Advert       -> http://localhost:8083/swagger-ui.html
Notification -> http://localhost:8084/swagger-ui.html
Lookup       -> http://localhost:8086/swagger-ui.html
Favorite     -> http://localhost:8088/swagger-ui.html
User         -> http://localhost:9000/swagger-ui.html
```


# General lookup to the system design;

![drawio](https://user-images.githubusercontent.com/62377943/159826577-0472f557-c8d0-499c-be15-7c797fb35257.png)


# Service Endpoints;

<img width="1792" alt="paymentsw" src="https://user-images.githubusercontent.com/62377943/159826793-b5137283-fc21-4f33-ab14-7b7d086f93b2.png">
<img width="1792" alt="usersw" src="https://user-images.githubusercontent.com/62377943/159826799-d7cbaac2-7277-4247-8a53-14c048c67f81.png">
<img width="1792" alt="advertsw" src="https://user-images.githubusercontent.com/62377943/159826802-a552ee8c-2f85-4ae7-a794-9066a66d20de.png">
<img width="1792" alt="favoritessw" src="https://user-images.githubusercontent.com/62377943/159826805-58ef4fc1-14b7-4d1a-96af-74dcfe8e51aa.png">
<img width="1792" alt="lookupsw" src="https://user-images.githubusercontent.com/62377943/159826813-07cbcc51-c215-4369-8594-96cb0c6848dd.png">
<img width="1792" alt="notificationsw" src="https://user-images.githubusercontent.com/62377943/159826818-ba3690c2-e611-474b-8084-85689b5aabcd.png">
<img width="1792" alt="packagesw" src="https://user-images.githubusercontent.com/62377943/159826820-3bc0892c-9f49-43ad-a8f6-575de38b0e58.png">


# Database Screens

<img width="921" alt="mongo" src="https://user-images.githubusercontent.com/62377943/159827331-1e9c7e6b-17c3-4f3c-8d7a-cd4d27aabe3e.png">
<img width="1223" alt="postgres" src="https://user-images.githubusercontent.com/62377943/159827333-3eca2722-c6a0-4067-8ddb-0efd363ae880.png">
<img width="1792" alt="rabbitmq" src="https://user-images.githubusercontent.com/62377943/159827337-8c6e40f9-3fa3-4d98-b483-9269e9724a9d.png">
<img width="944" alt="elasticsearch" src="https://user-images.githubusercontent.com/62377943/159827343-3abeb88d-2043-49d1-b4fd-54917f795114.png">

