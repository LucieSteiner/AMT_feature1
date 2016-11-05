# Rest API Documentation #

The Rest API allows to manage users with the following actions: 

1. Retrieve all information about all users (except passwords)
2. Create a new user
3.  Retrieve all information about one particular user (except password)
4.  Update a particular user's information (except password)
5.  Update a particular user's password
6.  Delete a user

A postman script with all the corresponding requests is available [here](AMT.postman_collection.json). There are two variables that need to be changed:

- url: the address of the application server
- user: the username of the user to delete/update/retrieve


More details on how to perform each of these actions:
## 1. Retrieve all information about all users (except passwords) ##

This is done using a GET request: 

	GET /bootcamp2/api/users

The output contain the username, first name, last name and e-mail address of every user.


## 2. Create a new user ##

This is done using a POST request:


	POST /bootcamp2/api/users
	Content-Type: application/json

	{
		"username":"admin",
		"firstName":"Lucie",
		"lastName":"Steiner",
		"email":"lucie.steiner@heig-vd.ch",
		"password":"s3cr3tp4ssw0rd"
	}
## 3.  Retrieve all information about one particular user (except password) ##

This is done using a GET request:

	GET /bootcamp2/api/users/{{user}}

Instead of {{user}}, there should be the username of the user you want to get information about.

## 4.  Update a particular user's information (except password)##

This is done using a PUT request:

	PUT /bootcamp2/api/users/{{user}}
	Content-Type: application/json

	{
		"firstName":"Nouvel",
		"lastName":"Administrateur",
		"email":"nouveladmin@example.com"
	}

Instead of {{user}}, there should be the username of the user you want to update.

## 5.  Update a particular user's password ##

This is done using a PUT request:

	PUT /bootcamp2/api/users/{{user}}/password
	Content-Type: application/json

	{
		"password":"1234"
	}

Instead of {{user}}, there should be the username of the user you want to update.

## 6.  Delete a user ##

This is done using a DELETE request:

	DELETE /bootcamp2/api/users/{{user}}

Instead of {{user}}, there should be the username of the user you want to delete.