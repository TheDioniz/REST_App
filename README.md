# REST_App

This project represents simple rest application which allows to Create Read Update and Delete Java objects in H2 embedded database.

## Launch the application
java -jar rest_app.jar

## Enter in browser
http://localhost:8080/person/ 

Following JSON should be presented:

[
	{
		"id": 1,
		"name": "d2",
		"email": "d2@o2.pl",
		"sex": "male"
	}
]


## API

**Postman** addon or **cURL** recommended

*Create via HTTP POST method:*

http://localhost:8080/person/

Request body (JSON format):

  {
    "name": "anotherPerson",
    "email": "another@o2.pl",
    "sex": "male"
  }
  
*Read via HTTP GET method:*

http://localhost:8080/person/

*Update via HTTP PUT method:*

http://localhost:8080/person/{id}
ex. http://localhost:8080/person/1

Request body (JSON format):

  {
    "name": "anotherPerson",
    "email": "another@o2.pl",
    "sex": "male"
  }
  
*Delete via HTTP Delete method:*

http://localhost:8080/person/{id}
ex. http://localhost:8080/person/1


