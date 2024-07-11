# CoderHack Leaderboard API

A RESTful API service built with Spring Boot to manage the leaderboard for a coding platform. The application uses MongoDB to persist user data.

## Features

### User Management

* **User Registration**: Register a new user with a unique User ID and Username.
* **User Deletion**: Deregister a specific user from the contest.

### Score Management

* **Update Score**: Update the score of a specific user.

### Badge Awarding

* Award badges to users based on their scores:
	+ **Code Ninja**: 1 <= Score < 30
	+ **Code Champ**: 30 <= Score < 60
	+ **Code Master**: 60 <= Score <= 100

### User Retrieval

* **Get All Users**: Retrieve a list of all registered users.

## Installation and Usage
### Prerequisites
* Java 17 or higher
* MongoDB
* Postman for API testing

### Getting Started

1. **Clone the repository**:

    ```bash
    git clone https://github.com/UdayNarayan95/coderHack.git
    ```

2. **Navigate to the project directory**:

    ```bash
    cd CoderHack
    ```

3. **Build and run the application using Gradle**:

    ```bash
    ./gradlew bootrun
    ```

## API Endpoints

* **GET /users**: Retrieve a list of all registered users
* **GET /users/{userId}**: Retrieve the details of a specific user
* **POST /users**: Register a new user to the contest
* **PUT /users/{userId}**: Update the score of a specific user
* **DELETE /users/{userId}**: Deregister a specific user from the contest

### API Testing

For testing the API endpoints, you can use the following Postman Collection:

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/19032644-4d68760a-dd67-48f8-a2a2-37091dc37e0a?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D19032644-4d68760a-dd67-48f8-a2a2-37091dc37e0a%26entityType%3Dcollection%26workspaceId%3D8ffcea5c-fb17-4ea1-a212-023358a283e2)       

