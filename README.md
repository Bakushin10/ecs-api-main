#  java-reactive


reactive java repo for component test with docker/docker-compose. 

- `gradle componentTestDocker` does the following
	- `composeUp` spins up all containers needed to run the component test
	- `waitForService` checks if all necessary containers are up and running 
	- `componentTest` executes the component test
	- `composeDown` stops all running containers 

- `gradle buildDockerimage` build java service 


#### Env variables
`.env` contains environment variables. `R2DBC_HOST_LOCALHOST` for localhost and change the value in `R2DBC_HOST_CONTAINER` when the instance of the running container changes. 


Task definitions are written with [gradle properties](https://docs.gradle.org/current/dsl/org.gradle.api.Task.html#N187F7) 