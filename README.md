# Football Players Statistics API

# Project Overview

This project is a Spring Boot REST API for managing football statistics data and calculating statistics about players. 
The system has four entities:

- Teams
- Players
- Matches
- Records

Technologiesused:

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL

# Setup / Installation / Run

Prerequisites

PostgreSQL installed on your computer.
Create a database named FootballStat in pgAdmin or via your PostgreSQL server.
Update application.properties with your database username and password:

spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

If your OS already has environment variables set for the DB credentials, you can skip this step.

The server is set to run on port 8081. Make sure this port is free.


#Running the Application

1. Download the JAR file from the release page: app-0.0.1-SNAPSHOT.jar
2. Open a terminal or command prompt in the folder where the JAR is located.
3. Run the application:
**java -jar app-0.0.1-SNAPSHOT.jar**
4. After Spring Boot starts, open your browser and go to:
   http://localhost:8081

Make sure the port is not used by another application.

#Testing

It is recommended to use Postman or similar tools to send HTTP requests to test the API endpoints.

# Main Algorithm – MVP Pair

The main go of the app is to find the pair of players who have played together the longest total time across all matches.


# Algorithm Explanation

The algorithm works in several steps:

1. The app loads all data from the csv file to the data base.
1.1 The framework checks the database is empty. 
1.2 If the tables are empty then the database is being populated from the csv file.
1.3 If the tables are not empty then the information is not being loaddedfrom the csv.
//In future versions logic will be implemented to check each row in every table and only unique entries//
1.4 The chech and databasepopulation is done before the app is being started.

2. When the URL api/players/mvp is loadded:
2.1 All records are loadded from the database and sorted by match id.
2.2 Players are grouped by match.
2.3 Data for when the player started the game(minutes from match) and when player ended the game (minutes from match) is loadded
2.4 The algorithm interates thorugh all mathes and players and calculates and stored into HashMap.
2.5 The data in the HashMap is streamed and the object with the highest value is being returned as exit.
2.6 The final data is returned as Json object.



# Additional REST API Endpoints are implemented in the app

1. Teams

POST   /api/team
GET    /api/team
GET    /api/team/{id}
PUT    /api/team/{id}
DELETE /api/team/{id}


2. Players

POST   /api/players
GET    /api/players
GET    /api/players/{id}
PUT    /api/players/{id}
DELETE /api/players/{id}


3. Matches

POST   /api/matches
GET    /api/matches
GET    /api/matches/{id}
PUT    /api/matches/{id}
DELETE /api/matches/{id}


4. Records

POST   /api/records
GET    /api/records
GET    /api/records/{id}
PUT    /api/records/{id}
DELETE /api/records/{id}