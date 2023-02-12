## About
Test automation framework for KLIX online payments application. Page Object Model is using as a design pattern.

### Tech stack
- Java 11+
- Spring Boot 2.2.7
- Maven 3+
- Node 14+
- TestNG
- Allure

## How to start
1. Install Java 11 SDK
2. Install Maven
3. Add environment variables and define PATH's
4. Install Node 14+
5. Clone the GitLab repository
6. Open project with any IDE and import dependencies
7. Install Allure Reports command line executor
8. Execute tests
9. Generate and open reports

## Execution
Auto tests are executing via Maven and TestNG. Tests are describing inside xml test suits.

Auto tests executing from command line:
```
mvn clean test -Dsurefire.suiteXmlFiles=./src/test/resources/suites/frontend/e2e.xml -Dspring.profiles.active=stage

mvn clean test -Dsurefire.suiteXmlFiles=./src/test/resources/suites/backend/default.xml

mvn clean test -Dsurefire.suiteXmlFiles=./src/test/resources/suites/backend/default.xml -rf :payments-backend

mvn clean test -Dsurefire.suiteXmlFiles=./src/test/resources/suites/backend/default.xml -Dspring.profiles.active=stage
```

## Reporting
### Setup
<b>npm install -g allure-commandline --save-dev</b>

## Generate reports 
- allure generate allure-results

## Open reports
- allure open allure-report

*local allure server will be opened with tests results