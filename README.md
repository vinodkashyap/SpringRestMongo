# SpringRestMongo
Sample `Java` project with `Spring`, `REST` and `MongoDB` based on `Maven`. It uses default database of `MongoDB` i.e. *`test`*. It will automatically create a *`collection`* (*table* in RDBMS) with name *`schools`*.

## Technologies Used
* Java 8
* Spring 4
* Maven 3
* MongoDB 

## Requirements
* `MongoDB` on your system and should be started
* `Java 8`
* `REST` client: You can use any `REST` client out there. I am using [POSTMAN] (https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en) plugin for Chrome.

## How to Run
```
It is a `REST` based project and there is no UI for it.
So you need to test in some `REST` client. 
Simply deploy application on your local server and access using `REST` client
```

See below `REST` hits that will work:
* **Fetch all schools**: `GET http://localhost:8080/spring-mongo`
* **Insert dummy data**: `POST http://localhost:8080/spring-mongo`
* **Update school**: `PUT http://localhost:8080/spring-mongo/{school_id}`. This will only update schools name to `British International`
* **Fetch a school by its id**: `GET http://localhost:8080/spring-mongo/{school_id}`
* **Delete a school by its id**: `DELETE http://localhost:8080/spring-mongo/{school_id}`
* **Delete all schools**: `DELETE http://localhost:8080/spring-mongo`


