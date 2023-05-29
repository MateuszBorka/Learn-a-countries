# Learn-a-countries

Learn a countries is a project, that was created as test task for XX company. It is an app, that uses two APIs to get information about random countries of continent. This GitHub repostiory represents backend part of application, that is written in Java using Sping framework. 

How to launch backend part off app?

1) Download app from GitHub using "code" button as ZIP archive, unpack it(or use git clone command). Start terminal from Learn-a-countries-master(from which you can see Dockerfile)
2) Make sure that Docker engine is running on your PC.
3) Go to the main folder of repository(Learn-a-countries).
4) Use console command "docker build -t learn-a-countries-back:1 .". That will craete a docker image, it is a necessary component while launching a docker container. Wait for terminal to end execution.
5) Use console command "docker run -p 8080:8080 learn-a-countries-back:1". This command will run a docker container, that is listening in port 8080. 

From now on frontend part of app can get access to the backend part from this port. Make sure you launch frontend part.
