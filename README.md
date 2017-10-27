# Angular2SpringBootApp
This project contains angular 4 with spring boot
We can run this project 2 different ways
1. Client and server in different mode.                                                                                                    
	-->	command prompt go to frontend folder and run below commands                                                                 
	-->	npm install                                                                                                                
        -->	npm start                                                                                                                      
	--> 	PersonalityWebAppApplication.java file run as java application.                                                            
	Note:- In this if app is not able to display then put base href="/" in index.html

2. War deployement into tomcat.                                                                                                                 
     Eclipse or springsuite or command promt where pom file is present                                                                      
		-->	mvn clean install                                                                                                              
		-->	Take war file present in target folder and rename it to PersonalityWebApp and deploy.                                                           
3. Technoligies used.                                                                                                                      
    Spring boot(web,jpa),h2 db,Angularjs x,Nodejs,Bootstrap.
                                                                                                                                            
4. Maven build profiles.                                                                                                                       --> We have 2 profile to our project                                                                                                           
    -->1 for both backend and frontend 2 for only backend build.
5. Project Details.
    --> Intially when application starts it loads the json data into h2 db. After that it play around the db for fetching the details for the form and saving the form data                                                                                                   
6. Accessing h2 db from chrome or firefox once application is up and running.                                                            http://localhost:8080/PersonalityWebApp/h2

================================================================Docker configuration realted=======================

To start docker
1.start docker quick start in windows mechine and type below command there.Make sure maven clean install ran already and jar is available in target floder.
>come to this app location> docker build -f Dockerfile -t dockerapp .
Dockerfile -----current floder docker file name
dockerapp ----docker image willbe created with this name
> docker run -p 8080:8080 dockerapp

test app with below in browser--here ip address will change.So to know ip type this command>docker-machine ip
192.168.99.100:8080/PersonalityWebApp/index.html

====================================
docker cmds

app reference

https://www.youtube.com/watch?v=Ojs9I-gnkc8









    
		
		
