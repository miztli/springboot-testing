### Useful commands

- List the project properties: `gradle properties`
- List all tasks: `gradle list --all`

### Recommended project structure

DEFINITION | CODE PATH | RESOURCES PATH
Source code | `main/java/com/example/testing` | `main/resources` 
Unit tests | `test/java/com/example/testing` | `main/resources` 
Integration tests | `integration-test/java/com/example/testing` | `main/resources` 

### Testing Guidelines

- Integration and unit tests must have different source directories. The src/integration-test/java directory must contain the source code of our integration tests and the src/test/java directory must contain the source code of our unit tests.
- Integration and unit tests must have separate resource directories. The src/integration-test/resources directory must contain the resources of our integration tests. The src/test/resources directory must contain the resources of our unit tests.
- We must be able to configure compile time and runtime dependencies for our integration tests.
- We must be able to run either our unit tests or integration tests.
- We must be able to run all tests.
- If an integration test fails, our build must fail as well.
- Integration and unit tests must have separate HTML reports.

### Running our tests

- We must be able to run our only unit tests.
- We must be able to run only integration tests.
- We must be able to run all tests.

Run unit tests only
`gradle clean test`
`gradle clean build -x integrationTest`

Run only integration tests
`gradle clean integrationTest`
`gradle clean build -x test`

Run all tests
`gradle clean test integrationTest`
`gradle clean build `

### Test results

`build/reports/test/integrationTest`
`build/reports/test/test`

### Resources

https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-integration-testing/
https://springtestdbunit.github.io/spring-test-dbunit/