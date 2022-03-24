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



###You can see the api documentation on the swagger page. Swagger will be available on;
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

![](../Graduation Project/drawio.png)