1.application runs using Docker also
To start docker
1.start docker quick start and type below command there
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