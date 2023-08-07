# **Getting Started**

### **What this is**

This is a simple template to facilitate the development startup of our Backend Challenge.
Provided in this project is a stripped down Springboot application, with a Postgres database, orchestrated with Docker.

### **Requirements**

 - Maven
 - Java 17
 - Docker

### **Start-up**

Run the following commands in the command line:

    - mvn clean install
    - docker build -t challenge-1.0.0.jar .
    - docker-compose up

## **Instructions**

### Curl Instructions

For a GUI of all the requests available use Swagger on http://localhost:8080/challenge/swagger-ui/index.html

top-zones - 
Get the 5 top zones by dropoff or pickup, if you want to order by pickup just put 'PICKUP' on query param order instead.

```shell
curl -X 'GET' 'http://localhost:8080/challenge/top-zones?order=DROPOFF' \
  -H 'accept: application/json'
```

zone-trips - 
Get the sum of pickups and drop offs on the date sent plus id from zone
```shell
curl -X 'GET' 'http://localhost:8080/challenge/zone-trips?zoneId=166&date=2023-01-01' \
  -H 'accept: application/json'
```

list-yellow - 
Get the yellow taxis list paginated by your wishes.
```shell
curl -X 'GET' 'http://localhost:8080/challenge/list-yellow?page=0&size=10&sort=pickupZone.name,asc' \
  -H 'accept: application/json'
```

### Csv Loading
The loading of data is direct to the database using copy and program commands. If you want to load data just put the zone.csv, green.csv and yellow.csv on main/resources/csv

### Flyway
Was used flyway to keep the database organized and possibility of developing easier with migrations. 

### Tests
Init created for it but tests were not able to be developed in time. With that if you wish can develop from the init files created for it.

