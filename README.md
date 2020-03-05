# database-web-app
This is a full working basic Customer Relationship Management (CRM) system developed with Spring MVC, Hibernate and MySQL database.

This educational project has been done with the help of tutorials in [Udemy Spring & Hibernate for Beginners](https://www.udemy.com/course/spring-hibernate-tutorial/) course.

## Technologies and Frameworks
- Java
- Maven
- Spring MVC
- Hibernate
- MySQL
- JUnit5, AssertJ, Mockito
- CircleCI

## Features
- Add/Update/Delete cutomers
- List customers in the database
- User authentication and athurization

## Setup
This project uses Maven. If you have Maven installed on your system, navigate to the root directory of the project and run:
```
mvn clean package
```
If you do not have maven installed, you use:
```
mvnw clean package
```
After the building process, you can go the targer directory and run the jar file with:
```
java -jar [filename].jar
```
### Database
Run the [sql scripts](https://github.com/rzgholizadeh/database-web-app/tree/master/other/sql-scripts) to create the user and the database with some initial data in it.

The username and password of the database user is "springstudent".

The sql scripts has been developed by the Udemy course instructor.


