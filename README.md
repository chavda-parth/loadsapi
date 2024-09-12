
## Title

Spring REST API for Load Management


## Overview

This project is a Spring Boot application that provides a REST API for managing load records. It uses PostgreSQL as the database and follows a standard CRUD (Create, Read, Update, Delete) approach for handling `Load` entities.
## Table of Contents

[Features](#features)

[Technologies](#technologies)

[Installation](#installation)

[API Endpoints](#api-endpoints)

[Entity Structure](#entity-structure)
## Features

- **CRUD Operations**: Create, Read, Update, and Delete operations for `Load` entities.
- **Filter Loads**: Retrieve loads based on the `shipperId`.
- **UUID Handling**: Proper handling of UUIDs for `shipperId`.


## Technologies

- **Spring Boot**: Framework for building the REST API.
- **PostgreSQL**: Database for storing `Load` records.
- **Java**: Programming language.
- **Gradle**: Dependency management and build tool.
## Setup

Install my-project with npm

### Prerequisites

- Java 17 or higher
- PostgreSQL
- Gradle

### Steps to Set Up

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd loadsrestapi
   ```
2. **Configure Database**

Ensure PostgreSQL is installed and running. Create a database and configure the database settings in `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Build the Project**

```bash
./gradlew build
```

4. **Run the Application**

```bash
./gradlew bootRun
```


    
## API Endpoints

### Get All Loads

- Endpoint: GET /loads
- Description: Retrieve a list of all loads.
- Response: List of Load objects.

### Get Loads by Shipper ID

- Endpoint: GET /load
- Description: Retrieve loads with a specified shipperId.
- Parameters:
    - shipperId (Query Parameter, required)

### Get Load by ID

- Endpoint: GET /load/{loadId}
- Description: Retrieve a load by its loadId.
- Parameters:
    - loadId (Path Variable, required)
- Response: Load object.

### Add a New Load

- Endpoint: POST /load
- Description: Add a new load record.
- Request Body: Load object
- Response: Success message.

### Update a Load

- Endpoint: PUT /load/{loadId}
- Description: Update an existing load record.
- Parameters:
    - loadId (Path Variable, required)
- Request Body: Updated Load object
- Response: HTTP Status OK or Internal Server Error.

### Delete a Load

- Endpoint: DELETE /load/{loadId}
- Description: Delete a load by its loadId.
- Parameters:
    - loadId (Path Variable, required)
- Response: HTTP Status OK or Internal Server Error.



## Entity Structure

### Load Entity

- loadId: Unique identifier for the load (auto-generated).
- loadingPoint: Location where the load is picked up.
- unloadingPoint: Location where the load is delivered.
- productType: Type of product being transported.
- truckType: Type of truck used for transportation.
- noOfTrucks: Number of trucks used.
- weight: Weight of the load.
- comment: Optional additional information.
- shipperId: UUID of the shipper.
- date: Date of the load.
