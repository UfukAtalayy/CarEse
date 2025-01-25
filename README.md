# CarEse
 Configure the database in application.properties file.
 spring.datasource.username=your_username
spring.datasource.password=your_password
# Technologies Used
Backend:
Spring Boot: RESTful API development
Hibernate: ORM for database interactions
PostgreSQL: Database management
API Testing:
Postman: Testing API endpoints
# Test API Endpoints:
Example endpoints:
GET	/api/vehicles	
POST	/api/vehicles	
PUT	/api/vehicles/{id}
DELETE	/api/vehicles/{id}

An example POST request
POST /api/vehicles
Content-Type: application/json

{
    "brand": "Toyota",
    "model": "Corolla",
    "year": 2021,
    "fuelType": "Petrol",
    "pricePerDay": 500.00,
    "priceForSale": 20000.00,
    "mileage": 15000,
    "location": "Istanbul"
}

Note: The frontend is under development. Necessary information will be added as the front end of the project is developed.
