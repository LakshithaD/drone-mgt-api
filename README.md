# Drone Management API
This application provide the required REST Endpoints to manage drone pool.
Functionalities includes
1. Registering a drone;
2. Loading a drone with medication items;
3. Checking loaded medication items for a given drone;
4. Checking available drones for loading;
5. Check drone battery level for a given drone;

## Requirements

For building and running the application you need:

- [JDK 11]
- [Maven 3](

# Running the application locally
You can use an IDE to run the project.

Alternatively you can run using following command in shell
mvn spring-boot:run

#You can access the swagger ui once application is running
http://localhost:8080/drone-api/swagger-ui/

#You can access the h2 console ui once application is running
http://localhost:8080/drone-api/h2-console/
username - sa
password - password
jdbc url - jdbc:h2:mem:drone_db

schema is defined in 
schema.sql


Initial data insert queries are defined in 
data.sql