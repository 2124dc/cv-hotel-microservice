Here is the complete `README.md` file in markdown format:


# Hotel Management System API (Hotel-MS)

## Overview

The Hotel Management System (Hotel-MS) API is designed to manage hotel-related entities such as products (e.g., menu items) and tables. It provides RESTful endpoints for CRUD operations on these entities, and it integrates with MongoDB for persistent storage.

This API is built using Spring Boot and follows the OpenAPI 3.0 standard for API documentation.

## Table of Contents

1. [Features](#features)
2. [Architecture](#architecture)
3. [Prerequisites](#prerequisites)
4. [Installation](#installation)
5. [Configuration](#configuration)
6. [Running the Application](#running-the-application)
7. [API Endpoints](#api-endpoints)
8. [Data Models](#data-models)
9. [Security](#security)
10. [Testing](#testing)
11. [Troubleshooting](#troubleshooting)
12. [License](#license)

## Features

- **CRUD Operations**: Perform Create, Read, Update, and Delete operations on `Product` and `Table` entities.
- **OpenAPI Documentation**: Provides detailed API documentation compliant with OpenAPI 3.0.
- **MongoDB Integration**: Uses MongoDB for storing `Product`, `Table`, `Hotel`, and `Owner` data.
- **Modular Design**: Built with a modular architecture, making it easy to extend or modify.
- **Security**: JWT-based authentication and authorization for API access.

## Architecture

The Hotel-MS API follows a microservices architecture and is built using Spring Boot. The following components are included:

- **Product Service**: Manages product-related operations (e.g., menu items).
- **Table Service**: Manages table-related operations (e.g., restaurant seating).
- **MongoDB**: Used as the primary database for storing `Product`, `Table`, `Hotel`, and `Owner` data.
- **Spring Security**: Secures the API using JWT tokens.
- **Spring Cloud**: For configuration management and service discovery (optional if integrated with a microservices environment).

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 8** or higher
- **Maven 3.6** or higher
- **MongoDB** (running instance)
- **Git** (optional, for version control)
- **Docker** (optional, for containerized deployment)

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/hotel-ms.git
   cd hotel-ms
   ```

2. **Build the Project**:
   ```bash
   mvn clean install
   ```

3. **Set Up MongoDB**:
   - Ensure that MongoDB is running on its default port (27017). You can modify the connection settings in the `application.properties` file.

## Configuration

The application can be configured using `application.properties` located in the `src/main/resources` directory.

### MongoDB Configuration

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/hotelms
spring.data.mongodb.database=hotelms
```

### Server Configuration

```properties
server.port=8062
```

### JWT Security Configuration

```properties
jwt.secret=mySecretKey
jwt.expiration=86400
```

### Logging Configuration

```properties
logging.level.root=INFO
logging.level.com.yourcompany.hotelms=DEBUG
```

## Running the Application

You can run the application using Maven:

```bash
mvn spring-boot:run
```

Alternatively, you can package it as a JAR and run it:

```bash
java -jar target/hotel-ms-1.0.0.jar
```

The application will be accessible at `http://localhost:8062/hotel-ms`.

## API Endpoints

### Products

- **GET /product**: Get a list of products by hotel ID.
- **POST /product**: Add a new product with hotel association.
- **PUT /product**: Update an existing product by hotel ID.
- **DELETE /product**: Delete a product by its ID.
- **PATCH /product**: Partially update a product's function by product ID.

### Tables

- **GET /table**: Get a list of tables by hotel ID.
- **POST /table**: Add a new table with hotel association.
- **PUT /table**: Update an existing table by hotel ID.
- **DELETE /table**: Delete a table by its ID.
- **PATCH /table**: Partially update a table's function by table ID.

### Example Requests

```bash
# Example GET request to retrieve products by hotel ID
curl -X GET "http://localhost:8062/hotel-ms/product?hotelId=123" -H "accept: application/json"

# Example POST request to add a new product
curl -X POST "http://localhost:8062/hotel-ms/product?hotelId=123" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"name\": \"Pasta\", \"type\": \"Lunch\", \"pricePerQty\": 150.00, \"image\": \"image-url\" }"
```

## Data Models

### Product

```yaml
id: string
name: string
type: enum [Breakfast, Lunch, Dinner]
pricePerQty: number
image: string
```

### Table

```yaml
id: string
status: enum [occupied, unoccupied]
tableLocation: string
isActive: boolean
noOfPeopleCanSeat: integer
```

### Hotel

```yaml
id: string
name: string
address: 
  $ref: '#/components/schemas/Address'
owner: 
  $ref: '#/components/schemas/Owner'
telephone: string
mobile: string
email: string
```

### Address

```yaml
id: string
plotNo: string
streetName: string
landmark: string
pin: string
city: string
```

### Owner

```yaml
id: string
name: string
email: string
mobile: string
dob: string
gender: string
address: 
  $ref: '#/components/schemas/Address'
```

## Security

This API uses JWT for authentication. Each request to the API must include a valid JWT token in the `Authorization` header:

```bash
Authorization: Bearer <token>
```

## Testing

You can write and run unit tests using JUnit and Mockito. To run all tests:

```bash
mvn test
```

## Troubleshooting

If you encounter issues, consider the following steps:

- Ensure MongoDB is running and accessible.
- Verify that your `application.properties` file is correctly configured.
- Check logs for error messages and stack traces.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.


This markdown file provides an extensive guide for your Hotel Management System API, covering installation, configuration, usage, and more.