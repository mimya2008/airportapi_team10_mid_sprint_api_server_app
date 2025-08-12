This project is a Full-Stack Spring Boot REST API that manages Cities, Airports, Airlines, Aircraft, Passengers, and Flights. It uses a MySQL database and exposes endpoints for CRUD operations and query-based results.
Below are the key user stories for our Airport Management System, along with the API routes used to fulfill each one.


To start the project:
1. Java 21, Maven, Spring Boot, Spring Data JPA
2. MySQL installed and running, A database named airport_db created in MySQL
3. Postman (for manual API testing)

Updated application.properties with following code:
                                                    spring.application.name=airport-api
                                                    spring.datasource.url=jdbc:mysql://localhost:3306/airport_db
                                                    spring.datasource.username=root
                                                    spring.datasource.password=Keyin202!
                                                    spring.jpa.hibernate.ddl-auto=update
                                                    spring.jpa.show-sql=true
                                                    
                                                    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
                                                    spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration


Testing with Postman
1. As an admin, I want to manage cities so that I can keep location information up to date.
    Create a City:
    POST /city
    {
    "name": "Toronto",
    "state": "ON",
    "population": 6000000
    }
    
    Get All Cities:
    GET /city
    
    Update a City:
    PUT /city/{id}
    
    Delete a City:
    DELETE /city/{id}

2. As an admin, I want to manage airports so that flight locations are accurate.
   Create an Airport:
   POST /airport

   Get All Airports:
   GET /airport

   Update an Airport:
   PUT /airport/{id}

   Delete an Airport:
   DELETE /airport/{id}

3. As an admin, I want to manage airlines so that carrier details are available for flights.
   Create an Airline:
   POST /airlines

   Get All Airlines:
   GET /airlines

   Update an Airline:
   PUT /airlines/{id}

   Delete an Airline:
   DELETE /airlines/{id}

4. As an admin, I want to manage aircraft so that the system knows which planes are assigned to flights.
   Create an Aircraft:
   POST /aircraft

   Get All Aircraft:
   GET /aircraft

   Update an Aircraft:
   PUT /aircraft/{id}

   Delete an Aircraft:
   DELETE /aircraft/{id}

5. As an admin, I want to manage passengers so that I can assign them to flights.

   Create a Passenger:
   POST /passenger

   Get All Passengers:
   GET /passenger

   Update a Passenger:
   PUT /passenger/{id}

   Delete a Passenger:
   DELETE /passenger/{id}

6. As a user, I want to view upcoming arrivals and departures for a selected airport so that I can track flights.

   View Arrivals:
   GET /flights/arrivals?airportName={name}

   View Departures:
   GET /flights/departures?airportName={name}


