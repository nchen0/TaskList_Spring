# java-todos

# Introduction

This is a basic todo database scheme with users and a todo list.

# Instructions

Create a REST api server to store and read data from the provided SQLite Database called todos.db. data.sql is the script that was used to populate the database.  Hint: use the crudy snack application worked through during the presents as a model!

The table layouts are as follows:

* TODO
  * todoid primary key, not null int
  * description string, not null
  * datestarted datetime // adding this is now a stretch goal
  * completed boolean (0 = false 1 = true)/ / adding this is now a stretch goal
  * userid foreign key (one user to many todos) not null 

* USERS
  * userid primary key, not null int
  * username string, not null
  
Expose the following end points

* GET /users - returns all the users
* GET /todos - return all the todos

* GET /users/userid/{userid} - return the user based off of the user id
* GET /users/username/{username} - return the user based off of the user name
* GET /todos/todoid/{todoid} - return the todo based off of the todo id

* GET /todos/users - return a listing of the todos with its assigned user's name
* GET /todos/active - return a listing of the todos not yet completed. // adding this is now a stretch goal

* POST /users - adds a user
* POST /todos - adds a todo

* PUT /users/userid/{userid} - updates a user based on userid
* PUT /todos/todoid/{todoid} - updates a todo based on todoid

* DELETE /users/userid/{userid} - Deletes a user based off of their userid and deletes all their associated todos
* DELETE /todos/todoid/{todoid} - deletes a todo based off its todoid

* Add Swagger Documentation to your REST APIs
  * Add custom responses to each of the follow error conditions
    * 200 - successfully retrieve list
    * 401 - not authorized for this resource
    * 403 - access to resource forbidden
    * 404 - resource not found

  * Add custom Swagger Documentation to each of the follow End Points. The rest of the end points may just have the default documentation.
      * GET /todos
      * GET /todos/users
      * GET /todos/active // adding this is now a stretch goal
      * PUT /todos/todoid/{todoid}
      * DELETE /todos/todoid/{todoid}
    * For a stretch goal - add custom responses to the rest of the end points

* Add flyway data migration
  * for this project we will just have the starting migration. The DDL for creating the tables can be found in the file tables.DDL

* the end points should return null when no data is found.

* change end points so they return data that is deleted or a new copy of updated data

* End points should return the data they worked with or nothing if no data was found

* Expose at least the following the actuator endpoints to help with system mangagement
   * /health
   * /inf
   * /metrics
   
   * Stretch goal - update each of these three actuator endpoints to report your own messages. 
   
