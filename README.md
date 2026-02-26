TripBudgeter
TripBudgeter is a Spring Boot application that calculates trip cost based on country daily expenses.
The system connects to a PostgreSQL database that stores countries and their daily cost (USD).
The user selects a country and number of days, and the system returns the total trip cost.

Technologies
Java 25
Spring Boot
Spring Data JPA
PostgreSQL
Docker
Swagger

API Endpoints
Get All Countries
GET
/api/trip/countries
Returns the list of countries from the database.

Calculate Trip Cost
GET
/api/trip/calculate?countryId=1&days=5
Returns total cost:
daily_usd × number_of_days

Data Source
The country daily cost values were collected manually from public online sources (Google search results).
The data is for educational purposes only and is not officially verified.

##How to Run (Docker – Recommended)##

This project runs using Docker Compose.
Make sure Docker Desktop is installed and running.

Step 1 – Create a New Folder

Create an empty folder anywhere on your computer.

Example:

mkdir tripbudgeter
cd tripbudgeter

Step 2 – Create docker-compose.yml

Inside the folder, create a file named:

docker-compose.yml

Paste the following content into it:

version: "3.9"

services:

  db:
    image: postgres:16
    environment:
      POSTGRES_DB: tripdb
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    volumes:
      - trip_pgdata:/var/lib/postgresql/data

  app:
    image: tm04/tripbudgeter:1.2
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/tripdb
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres

volumes:
  trip_pgdata:

Save the file.

Step 3 – Start the Application

Run:

docker-compose up -d

Docker will:

Download PostgreSQL

Download the TripBudgeter image from Docker Hub

Start both containers

Connect the application to the database

Step 4 – Open the Application

Open your browser and go to:

Swagger UI:

http://localhost:8080/swagger-ui/index.html

API example:

http://localhost:8080/api/trip/countries

To Stop the Application
docker-compose down

If you want to remove the database data:

docker-compose down -v

Author: TM

