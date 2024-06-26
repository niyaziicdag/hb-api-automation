# Rest Assured Api Automation

This project is created to automate tests for Rest Assured api test using RestAssured, Java, Cucumber.

## About the Project

This project is used to perform automation tests for Rest Assured Api get and post requests.

## Requirements

To run this project, the following software and tools need to be installed:

- Java JDK (version 8 or above)
- Maven
- Cucumber
- Git (optional)
- IDE (IntelliJ IDEA, Eclipse, etc.)

## Setup

1. **Clone the repository:**

    ```
    https://github.com/niyaziicdag/hb-api-automation.git
    ```

2. **Navigate to the project directory:**

    ```
    cd hb-api-test-automation
    ```

3. **Install dependencies:**

    ```bash
    mvn install
    ```
   
# Project tree

```
.
|-- src
|   |-- test
|   |   |-- java
|   |   |   |   |-- runners
|   |   |   |   |   |-- Runner
|   |   |   |   |-- stepDefinitions
|   |   |   |   |   |-- BaseSteps
|   |   |   |   |   |-- GetSteps
|   |   |   |   |   |-- PostSteps
|   |   |   |   |-- utils
|   |   |   |   |   |-- ConfigUtils
|   |   |   |   |   |-- RestUtils
|   |   |-- resources
|   |   |   |-- features
|   |   |   |   |-- PetStore.feature
|   |   |   |-- cucumber.options
|-- git.ignore
|-- pom.xml
|-- config.properties
|-- README.md
```

## Running Tests

To run the tests for this project, you can use the following Maven command:

```bash
mvn clean test -Dtest=Runner "-Dtags=@smoke"
```

## Screenshot

  <img src="https://i.imgur.com/rsySL83.png">
