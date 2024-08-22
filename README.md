# FlexCalc
Flexible Calculator Implementation

## Requirements

For building and running the application you need:

- [JDK 1.8]
- [Maven 3](https://maven.apache.org)

## Clone repo
git clone https://github.com/anablav/FlexCalc.git

## Build the application locally
```shell
mvn clean install
```

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `src/main/java/com/example/flexcalc/FlexcalcApplication.java` class from your IDE.
Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Running unit tests
```shell
mvn test
```

##Solution2:
This solution uses Functional Interface IOperation and the lambda expression for the Functional Interface is passed 
from the enum (Operation Enum). All the code for Solution2 is available in package "solution2".

REST APIs for testing is in Calculator2Controller.java
Unit test : Calculator2Test

