# WarmestDataStructure - Part A & Part B

## Project Overview
This project implements a data structure called **WarmestDataStructure** and exposes it through a **Spring Boot REST API**.

The system stores key-value pairs and always knows which key is the *warmest* -  
the most recently accessed key using `put` or `get` that was not removed.

The project is implemented in **two parts inside a single project**, as required.

---

## Part A - Core Data Structure
Part A contains the pure Java implementation of the data structure.

### Main Ideas
- **HashMap** for fast access to elements by key.
- **Doubly linked list** to keep the order of usage.

Each key is stored as a node in the linked list.  
Whenever a key is accessed or updated, its node is moved to the end of the list,  
making it the current warmest key.

All operations run in **O(1)** time complexity.

### Supported Operations
- `put(key, value)` - add or update a key (returns previous value or null)
- `get(key)` - return value and make the key warmest
- `remove(key)` - remove a key
- `getWarmest()` - return the warmest key or null if empty

---

## Part B - Spring Boot REST API
Part B exposes the data structure from Part A using **Spring Boot** and a REST API.

### Architecture
- **Controller** - handles HTTP requests
- **Service** - contains the business logic and holds the data structure
- **Data Structure** - the implementation from Part A

The service is a **singleton**, so the data is shared between all requests.

---

## Running the Project
1. Open the project in an IDE (for example IntelliJ IDEA).
2. Run the Spring Boot application:
   ```
   WarmestPartBApplication
   ```
3. The server starts on:
   ```
   http://localhost:8080
   ```

---

## Example API Usage
- `PUT /warmest/put?key=a&value=100`
- `GET /warmest/get?key=a`
- `DELETE /warmest/remove?key=a`
- `GET /warmest/warmest`

---

## Unit Tests
The project includes **unit tests written with JUnit 5**.

- Tests are located under:
  ```
  src/test/java/warmest
  ```
- The tests cover:
  - The full example scenario from the assignment
  - Correct behavior of `put`, `get`, `remove`, and `getWarmest`
  - Edge cases such as missing keys

These tests verify that the data structure behaves exactly as expected.

---

## Notes
- All data is stored **in memory** and resets when the application restarts.
- Part A and Part B are intentionally combined in one project:
  Part A provides the logic, and Part B exposes it via REST.
- The project uses **Java 11 or above**.
