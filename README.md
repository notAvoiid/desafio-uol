<h1 align="center">
  UOL Challenge
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Type&message=Challenge&color=8257E5&labelColor=000000" alt="Challenge" />
</p>

API to create users with random superhero codenames from the Justice League and the Avengers. This challenge belongs to UOL.

## Technologies
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [H2](https://www.h2database.com/html/main.html)

## Methods useds

- SOLID, DRY, YAGNI, KISS
- API REST
- Spring Data JPA
- Dependency injection
- Handling error responses
- Automatic Swagger generation with OpenAPI 3

## How to execute

- Clone git repository
- Build the project:
```
$ ./mvn clean package
```
- Run the application:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

The API can be accessed at [localhost:8080](http://localhost:8080).
Swagger can be viewed at [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

To make the HTTP requests below, the tool was used [INSOMNIA](https://insomnia.rest/download):

The API provides the following endpoints:


**API PLAYER**
```markdown
POST /api/player - Create a new player
GET /api/player - Retrieve all players
```

**BODY**
```json
{
  "id": "1",
  "name": "Teste",
  "email": "fulano@gmail.com",
  "phoneNumber": "99999999",
  "groupType": "AVENGERS"
}
```
