# weather-api

This project is created as per the requirements of the assignment provided by publicissapient.
The purpose of this project is to consume the OpenWeatherMap api .

### Design Principles :
This api has been developed using SOLID design principles. More info about SOLID 
design principles can be found on https://en.wikipedia.org/wiki/SOLID

### Requirements:
	
The assignment

• Develop, test and deploy a micro service to show the output of a city's next 3 days high and low temperatures.
  If rain is predicted in next 3 days or temperature goes above 40 degree celsius then mention 'Carry umbrella' or
  'Use sunscreen lotion' respectively, in the output, for that day. 
	


## Tech Stack

* Since I am java programmer and I've been using spring framework from past 10 years .
 The choice was quite obvious to use Spring Boot .
 Other than spring boot , maven , junit, docker , swagger, tomcat were used. 

## Installation

This project is java-based. So It requires Jdk 11 (or later) and Maven 3.6.3 (or later)  to run.

```sh
$ cd weather-api
$ mvn package
$ java -jar target/weather-api-1.0.0.jar 
```
Another way to run this api is to use docker (latest image is already pushed to docker hub)

```sh
$ docker run -p 8080:8080 rantidev7/weather-api:latest

```
Or if there is need to build new image then it can also be build and pushed to 
docker hub via 

```sh
$ cd weather-api
$ mvn jib:build
```
And then run 
```
$ docker run -p 8080:8080 rantidev7/weather-api:latest
```


## Running tests
After changes you can run tests using Maven command:
```sh
$ cd weather-api
$ mvn test
```

## Rest API

 As required, this API has 1 endpoint :
  1. /v1/weather/{city}


## Testing API
1. API can be tested using Postman/Soap Ui
2. Swagger is also included in api , I would suggest to use swagger then there is no need to perform extra work.

## Things included in current version :
1. JavaDocs are aslo included, to generate javadocs use 
	```
	$cd weather-api
	$ mvn javadoc:javadoc
	```
	Then go to the folder /target/site/apidocs

2. Google's code convention is being forced via the checkstyle.xml.
3. Swagger is included and automatic updation of swagger specification is done.

## Things to be included in future version :
1. CI/CD should also be implemented for this api.
2. If we want to move to microservioces architecture then probably we can look for Netflix OSS
    (apigateway , service descovery , cloud config etc.)
3. Current version doen't support maven/spring profiles , which needs to be implemented.
