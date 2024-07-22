# weather-api

### Design Principles :
SOLID - 
- Single Responsibility - One class doing only one thing - getting the weather, displaying it etc
- Open Closed - Open for extension, closed for modification
- Interface Segregation - Different interfaces for different tasks (only one here)
- Dependency inversion - Autowiring dependencies to avoid tight coupling

### Requirements:
	
The assignment

• Develop, test and deploy a micro service to show the output of a city's next 3 days high and low temperatures.
  If rain is predicted in next 3 days or temperature goes above 40 degree celsius then mention 'Carry umbrella' or
  'Use sunscreen lotion' respectively, in the output, for that day. 
	


## Tech Stack

Frontend : Next.js, Typescript, TailwindCSS
Service : Spring Boot, Docker, Jenkins

## Installation

```sh
$ mvn package
$ java -jar target/weather-api-1.0.0.jar 
```
Another way to run this api is to use docker (latest image is already pushed to docker hub)

```sh
$ docker run -p 8080:8080 dkp1903/weather-api:latest

```
Or if there is need to build new image then it can also be build and pushed to 
docker hub via 

```sh
$ cd weather-api
$ mvn jib:build
```
And then run 
```
$ docker run -p 8080:8080 dkp1903/weather-api:latest
```


## Running tests
After changes you can run tests using Maven command:
```sh
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

2. Swagger is included and automatic updation of swagger specification is done.