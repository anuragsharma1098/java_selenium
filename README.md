# Java Selenium WebDriver

A comprehensive Selenium WebDriver automation testing project built with Java and Maven. This project includes advanced testing scenarios, TestNG integration, data-driven testing, and extent reporting.

## Overview

This project demonstrates automation testing techniques using Selenium WebDriver with Java, covering:
- Basic locators (CSS selectors, XPath)
- WebDriver methods and waiting strategies
- Handling dynamic web elements (checkboxes, alerts, dropdowns)
- Advanced interactions (mouse actions, keyboard actions)
- Data-driven testing with Excel
- TestNG framework integration
- Listener implementation and extent report generation
- Page Object Model (POM) pattern

## Project Structure

```
selenium_webdriver/
├── src/
│   ├── main/
│   │   ├── java/          # Main source code
│   │   └── resources/     # Configuration files
│   └── test/
│       ├── java/          # Test classes organized by topics
│       └── resources/     # Test data and configurations
├── pom.xml                # Maven dependencies
├── reports/               # Test execution reports
└── screenshots/           # Screenshots captured during tests
```

## Test Topics Covered

- **Day 1**: Introduction to Selenium
- **Day 2-5**: Locators (CSS, XPath, XPath Axes)
- **Day 6-8**: WebDriver methods and navigation
- **Day 9**: CheckBox and Alert handling
- **Day 10**: Frames and iFrames
- **Day 11**: DropDown handling
- **Day 12**: Table handling
- **Day 13**: Dynamic pagination
- **Day 14**: Date pickers
- **Day 15-16**: Mouse and keyboard actions
- **Day 17**: JavaScript execution, scrolling, file uploads
- **Day 18**: Screenshots, headless mode, SSL, extensions
- **Day 19**: Broken links, SVG elements, Shadow DOM
- **Day 20-21**: Data-driven testing with Excel
- **Day 22-26**: TestNG framework and reporting
- **Day 27**: Page Object Model pattern

## Prerequisites

- Java 8 or higher
- Maven 3.6+
- Chrome/Firefox browsers with corresponding drivers
- TestNG framework

## Installation

1. Clone the repository:
```bash
git clone https://github.com/anuragsharma1098/java_selenium.git
cd java_selenium/selenium_webdriver
```

2. Install dependencies:
```bash
mvn clean install
```

## Running Tests

### Run all tests:
```bash
mvn test
```

### Run specific test class:
```bash
mvn test -Dtest=ClassName
```

### Run tests from specific suite:
```bash
mvn test -DsuiteXmlFile=src/test/resources/testngSuites/SuiteName.xml
```

## Test Reports

After test execution, reports are generated in:
- **TestNG Reports**: `target/test-output/`
- **HTML Report**: `reports/myReport.html`
- **Extent Reports**: Generated with Listeners

## Configuration

Test configuration is stored in:
- `testdata/config.properties` - Configuration settings

## Technologies Used

- **Selenium WebDriver**: Web automation
- **TestNG**: Test framework
- **Maven**: Build automation
- **Extent Reports**: Test reporting
- **Apache POI**: Excel data handling

## Author

Anurag Sharma

## License

This project is open source and available for educational purposes.
