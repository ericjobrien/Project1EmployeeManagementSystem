#Employee Management System
##Project Description
#### The purpose of this project was to build out a REST API using Spring MVC.  This project operates as the back-end for an Employee Management System.  It demonstrates the departments at a business, the managers at a business, and the employees at a business.
##Technologies Used
* Java, JDK 11
* Spring Boot version 2.6.2
* SQL Server
##Features
####The sole purpose of this project is to serve as a back-end for a web service application.
* Data persistence
* HTTP API route mapping
* MVC design pattern
##Getting Started
####To get started, there are a few minor steps to take:
1) Clone the repository from Git Hub
2) Ensure you have the correct environment variables on your local machine
   1) You may need to accept the Maven dependencies associated within the pom.xml file
3) You will need to configure the project to connect to a database
   1) In the resources directory, create a new file called application.properties
      1) You will need to look up how to do this
##Usage
4) Run the project
5) Open up Postman
   1) First you need to create a Post to create a department, where you are able to add both managers and employees
      1) Your POST request should be set to http://localhost:9000/department
      2) Type out a JSON request to feed data to the project
   2) Visit the controllers package to view additional API endpoints
6) If you do not have Postman installed, open up a terminal in the project
   1) Run this command curl http://localhost:9000/department
   2) This should return an empty array which notifies you the program is running
   3) You will need to populate data to the database as you see fit
