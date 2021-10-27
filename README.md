# ExampleStudy
The framework is a Webdriver,TestNG,Restassured,extent reports and java based test automation framework.
It provides option to the user to automate ui components.
Easily configurable using config.properties.

# Start Automating
Clone the code on local and start automating
git clone https://github.com/ravi-tester/ExampleStudyReports

# Usage
Chrome driver and Firefox driver supported for windows OS.
Safari driver supported for Mac OS.
This code works with windows and mac OS.
Based on need, you can add your favourite browser using WebDriverManager in base class.

# Run the code
Run the testng.xml with required test cases.
In case the user want to run only tests.
mvn clean test

# Configure the Framework
To configure the framework, please refer - config.properties

# Update test data
Goto config.properties and change "browser" option to desired browser.
Run testng.xml to run complete suite.

# Reporting and Logs
Extent report is used for reporting.
Logs will added in reports.
Run testng.xml and you can findout logs under "test-output\ExtentReportWithLogs.html"
Sample:
Logs can be added using "reportLog("====== Your LOG INFO ======") after extending UI_Base class;"
