# CSCI 602 REST API

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)

## Environment Setup (Students)

1.) Install Java JDK 11+. JDK located [here](https://openjdk.java.net/install/). If you have a Mac you can use `brew`.

```bash
brew install java
```

2.) Create your personal repository from Github. You should receive a unique link from your professor from Github Classroom that will generate a private repository within your Github account.
It should look something like this.

```bash
https://classroom.github.com/a/{classroomId}
```

3.) This will create your personal repository within the [Citadel CS Github Organization](https://github.com/CitadelCS).

4.) Clone down the repository from Github

```bash
git clone git@git.github.com:CitadelCS/csci-602-fall-2021-{yourUsername}.git
```

5.) Build the project

```bash
./mvnw clean install
```

You should see a success if everything is set up correctly.

6.) Run the API

```bash
./mvnw spring-boot:run
```

Access the API by visiting [http://localhost:8080/swagger-ui/index.html](http://localhost:5000/swagger-ui/index.html). From there you can hit the endpoints directly.

7.) Success!

## Resources

### Spring Boot

For further references with Spring Boot:

- [Spring Initializr](https://start.spring.io/)
- [Getting Started](https://spring.io/guides/gs/spring-boot/)

### Maven

For further references with Maven's dependency management framework:

- [Spring and Maven](https://spring.io/guides/gs/spring-boot/)
- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Apache Maven Getting Started](https://maven.apache.org/guides/getting-started/)

