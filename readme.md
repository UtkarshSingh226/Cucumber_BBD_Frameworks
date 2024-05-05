# Amazon Automation Test Framework with Cucumber

This project is an automated test framework for testing the functionality of the Amazon website using Selenium WebDriver and Cucumber.


## Overview

The Amazon Automation Test Framework is designed to automate the testing of various features of the Amazon website, including product search, adding items to the cart, navigating through different pages, and user authentication. The framework utilizes Selenium WebDriver for browser automation and Cucumber for behavior-driven testing (BDD), allowing tests to be written in a human-readable format.

## Project Structure

The project is structured as follows:

- `PageObject`: Contains page object classes that represent different pages of the Amazon website.
- `StepDefinitions`: Contains step definition classes that define the behavior of each test step in Gherkin scenarios.
- `Utils`: Contains utility classes, such as assertion utilities and wait utilities.
- `Features`: Contains feature files written in Gherkin syntax, defining test scenarios.

## Setup Instructions

To set up the project locally, follow these steps:

1. Clone the repository to your local machine.
2. Ensure you have Java Development Kit (JDK) installed.
3. Install Apache Maven build tool.
4. Install Chrome WebDriver for Selenium (if using Chrome browser).
5. Open the project in your preferred IDE.
6. Run `mvn clean install` to install dependencies and build the project.
7. Execute tests using `mvn test`.

## Usage

To run the automated tests, execute the test runner class `TestRunner.java` or run Maven command `mvn test`. You can also specify tags to run specific sets of tests using the `tags` parameter in the `@CucumberOptions` annotation in the `TestRunner` class.

