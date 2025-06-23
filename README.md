This project is a Spring Boot REST API that manages Cities, Airports, Passengers, and Aircraft. It uses a MySQL database and exposes endpoints for CRUD operations and query-based results.

To start the project:
1. Java 23 , Maven, Spring Boot, Spring Data JPA
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
HTTP Method	                Endpoint	                     Description
GET	                        /city	                         Get all cities
POST	                      /airport	                     Add a new airport
PUT	                        /passenger/{id}	               Update a passenger
DELETE	                    /aircraft/{id}	               Delete an aircraft

