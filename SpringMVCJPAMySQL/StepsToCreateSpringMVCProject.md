#	Steps to create Spring MVC Application

-	Create Spring MVC application from STS ide
-	Delete all the files added by STS Spring MVC archtype
-	Create tables
-	Create Domain Objects
-	Create Dao layer and inject persistence Context in Top most abstract class
-	Create Service Layer
-	Create Controller 
-	Create Configs 

	-	Hibernate Configs
	-	Spring MVC Configs
	-	App Intializer
	
-	Create View Resolver Bean in Spring MVC Configuration class
-	Create View in the Jsp's and place inside /WEB-INF folder


## Create Tables 

CREATE TABLE user 
(
	user_id INTEGER(10) AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    primary key(user_id)
);

SELECT * FROM user;
INSERT INTO user(first_name, last_name, email) values('Bharath', 'Ashok', 'bharath@iambh.com');
INSERT INTO user(first_name, last_name, email) values('Sharath', 'Ashok', 'sharath@iambh.com');
INSERT INTO user(first_name, last_name, email) values('Rahul', 'Gandhi', 'rahul@iambh.com');

commit;