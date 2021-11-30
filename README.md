###    Home task #19
1. all home task rules (git hub, gitignore, maven, tests)
2. new project
3. new POJO classes with inheritance (at least 1 parent)
4. use each of 3 JPA inheritance strategy
5. DAO
6. Tests

### What was done:
POJO classes were created to implement 3 inheritance strategies in Hibernate:
1. Shape, Circle and Rectangle classes are created to use singe table inheritance strategy;
2. Payment, Card and Cheque classes are created to use join table inheritance strategy;
3. Employee, FullTimeEmployee, PartTimeEmployee, classes are created to use join table inheritance strategy.
Also implemented DAO for these classes and some tests

## Technologies
Java version: 11 Postgres, database docker-compose, Flyway, Hibernate, Slf4j+logback, Lombok

###   How to used ?
Build project: $mvn clean install
$docker-compose up -d
mvn flyway:migrate
Run Runner.class
