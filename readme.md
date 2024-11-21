### docker command 

1. docker --version


Clear the docker compilation/build cache
2. docker system prune


Building the docker image
3. docker build -t <docker login>/<app name>:<version>

docker build -t sherlynkek/vttp5a-day3l:0.0.1 .


Check docker image create in local docker repo
4. docker image ls


Run the image inside the container
5. docker container run -d -t -p <exposed public port>:<application server port> <image name>
<br> 


Check docker container running
6. docker container ls


Stop a running container
Container id is seen when step 6 is done
7. docker stop <container id>


Start a stopped container
8. docker start <container id>


To remove a stopped container
9. docker rm <container id>


To delete image
10. docker rmi <image id>


### docker compile and push to railway

1. In railway.app, create a service (linked the project)
2. create the environment variable, SERVER_PORT=3000
3. In your project root folder (command prompt), execute railway login
4. Link the project, execute "railway link"
5. Deploy the project to railway, execute "railway up" 