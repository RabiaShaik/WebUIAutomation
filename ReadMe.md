UI Automation Tests
This project is for testing UI of an e-commerce web application using Java, Selenium WebDriver and cucumber. 
Browser a bit to know more about the application

Dependencies
Here are the dependencies used in the project for development & testing perspective.
Note - All are open source project and widely available over the web. Setup the machine with below applications to test the code further.

Java 1.8 and above - Coding Language
Selenium 3.141.59 - Front End Automation Test Utility
Maven - Dependency Management
TestNG - Unit Testing framework for Java
ExtentReports - Reporting framework for our tests
Log4j - Logging framework for our tests

Getting Started
The below steps will get you a copy of the project up and running, on your local machine for development and testing purposes.

1) Open your terminal and do a clone of this project.
   git clone https://github.com/rabia/uiAutomation.git
2) Navigate to the respective directory and run below command.
   mvn clean install
3) Above command will build the project along with test cases.
4) If you something like below text on terminal, means project ran successfully locally.
   [INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 90.721 s - in TestSuite
   [INFO]
   [INFO] Results:
   [INFO]
   [INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
   [INFO]
   [INFO]

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

Project Structure:

PageObjects : This folder consists of locators and actions for the pages
Configs : Consists of the properties which could be read from here.
StepDefinitions : Actual test steps for the features
Utilities : Readers to read the config file
Resources >Features : BDD framework feature files written in plain english
Pom.xml : Manages dependencies
ReadMe.md : Has instruction of the project
testNg.xml : File from which the entire tests can be run
RunCukesTest: Runner file for cucumber which has the details of the plugins used for reporting, paths of feature and step definitions
Logging : Logs the information so that we can debug in case of failure

Testing
Ideally, the developed script is tested well on mac machine Chrome/Firefox browser.
So, in case it does not works well then request you to first update your local installed browsers and then try to run the script. Still issues are coming, Please write back to me : jituvrma007@gmail.com

Test Reports
Here are a below steps to get a human readable cucumberhtml report.

1) Navigate to project folder where the project is stored locally.
2) Navigate to /target directory.
3) Find the logs inside cucumber-report/cucumber.html directory.
4) Open the file in browser and view the results


Taking screenshot on failed tests -> Please find the screen shots of failed test cases here "/report/screenShots". Please note that, the screenshot will also be attached to the .html report.


Bongarcia WebDriver Manager factory -> Consumed this so that we can avoid having the necessity of physical binaries.


Layers like, PageObjects, Test Layer, setup and infra layers are done. Using page object pattern, data driven framework, Factory pattern to initalize the driver. After all it is just a sample project, we can design and extend this framework to scale our smoke/sanity/regression based tests.


Run tests in parallel mode -> Yes from "WebTest_TestSuite" file, am passing "parallel="methods" which will do this. 
However I have kept the thread count to 1 by default. It can be easily changed inside the .xml file..


Ability to run tests for different browsers by configuring -> This is configured in config properties where we can mention the browser and then accordingly those browser would open up for testing.