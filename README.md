# SpringRestMongo
Demo Java project with Spring, REST and MongoDB

## Run
It is a REST based project and there is no UI for it.
So you need to test in some REST client.

There are few REST hits that will work.
```
* Fetch all schools: http://<server>:<port>/spring-mongo with GET
* Insert dummy data: http://<server>:<port>/spring-mongo with POST
* Update school: http://<server>:<port>/spring-mongo with PUT
* Fetch a school by its id: http://<server>:<port>/spring-mongo/{school_id} with GET
* Delete a school by its id: http://<server>:<port>/spring-mongo/{school_id} with Delete
* Delete all schools: http://<server>:<port>/spring-mongo with DELETE
```