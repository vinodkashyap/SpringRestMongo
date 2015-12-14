# SpringRestMongo
Demo `Java` project with `Spring`, `REST` and `MongoDB`

### Run
It is a `REST` based project and there is no UI for it.
So you need to test in some `REST` client. Simply deploy on your local server.

Below are some requirements for this to run:
* MongoDB on your system and should be started
* Java 8
* REST client: [POSTMAN] (https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en) plugin for Chrome or you can use of your choice :)

See below `REST` hits that will work:
* **Fetch all schools**: `GET` http://localhost:8080/spring-mongo
* **Insert dummy data**: `POST` http://localhost:8080/spring-mongo
* **Update school**: `PUT` http://localhost:8080/spring-mongo. This will only update schools name to `British International`
* **Fetch a school by its id**: `GET` http://localhost:8080/spring-mongo/{school_id}
* **Delete a school by its id**: `DELETE` http://localhost:8080/spring-mongo/{school_id}
* **Delete all schools**: `DELETE` http://localhost:8080/spring-mongo

### Technologies Used
* Java 8
* Spring 4
* Maven 3
* MongoDB 
