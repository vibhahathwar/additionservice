# additionservice

Additionservice is a REST API, which calculates the sum of numbers and provides output in JSON format as {"sum":addition of numbers}.

This application is developed using Java 8,Spring Boot 2.1.6. It consists of CalculatorController as a RESTController class for the application,calculatorService class includes validation and caculation part(logic),AdditionModel is the model class and exception handling is done by customCalculatorException class.

Unit test cases has been written in order to cover positive and negative test case scenarios.

Application can be run using Docker Container or Standalone Tomcat Server by deploying the war file and also it can be run on IDE like Eclipse by importing the project and run on server.

Below are the steps to run Application on stand alone Tomcat server:
------------------------------------------------------------------------------------------------------------

Pre-requisite : Tomcat, Maven 3.5.4, Java 8

Step 1 : clone the git repo https://github.com/vibhahathwar/additionservice.git and Navigate to additionService folder (cd additionservice)

step 2 : Clean and build the application using Maven. 
         mvn clean install 
         
step 3 : step 2 will generate the war file (additionservice.war) in the Target folder of additionservice.

step 4 : Copy the war file into tomcat webapps folder.

Step 5 : Start the tomcat.

Step 6 : In the web browser,enter url http://localhost:8080/additionservice/calculator/add?values=10,20
         output will be displayed in JSON format as {"sum" : 30.0}
         REST API can be tested using Postman also by providing the above mentioned url.
         
Step 7 : Unit test cases can be checked by using - mvn test.


Below are the steps to run this application on Docker Container: 
------------------------------------------------------------------------------------------------------------

Pre-requisites : Docker , Docker Compose 
                 (Application tested on Docker - 19.03.0-beta1 and docker-compose - 1.24.1 versions on Fedora 30)
                 It should work on 18.03+ versions of docker.
                 
[user@localhost ~]$ git clone https://github.com/vibhahathwar/additionservice.git
                   
[user@localhost ~]$ cd additionservice/ 

[user@localhost additionservice]$ docker-compose up -d ##run docker compose in background

[user@localhost additionservice]$ docker-compose ps ##check the services running and the portmappings
                  
[user@localhost additionservice]$ curl -XGET http://localhost:8888/additionservice/calculator/add?values=2,54,66
{"sum":122.0} 

[user@localhost additionservice]$ curl -XGET http://localhost:8888/additionservice/calculator/add?values=a,c
{"errorMessage":"Enter number/numbers delimited by (,)"} 

[user@localhost additionservice]$ curl -XGET http://localhost:8888/additionservice/calculator/add?values=3.55,5.77
{"sum":9.32}

