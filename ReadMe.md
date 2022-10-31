Excercise3:

**UI Automation Tests**
This project is for testing UI of an e-commerce web application using Java, 
Selenium WebDriver and cucumber. 
Browser a bit to know more about the application : https://www.saucedemo.com/

**Dependencies**
Here are the dependencies used in the project for development & testing perspective.
Note - All are open source project and widely available over the web. 
Setup the machine with below applications to test the code further.

**Tech Stack**
Java 1.8 and above - Coding Language
Selenium 4.5.3 - Front End Automation Test Utility
Maven - Dependency Management
TestNG - Unit Testing framework for Java
ExtentReports - Reporting framework for our tests
Log4j - Logging framework for our tests

**Getting Started**
The below steps will get you a copy of the project up and running, on your local machine for development and testing purposes.

1) Open your terminal and do a clone of this project.
   git clone https://github.com/RabiaShaik/WebUIAutomation.git
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

**Project Structure:**

**PageObjects :** This folder consists of locators and actions for the pages
**Configs :** Consists of the properties which could be read from here.
**StepDefinitions :** Actual test steps for the features
**Utilities :** Readers to read the config file
**Resources >Features :** BDD framework feature files written in plain english
**Pom.xml :** Manages dependencies
**ReadMe.md :** Has instruction of the project
**testNg.xml :** File from which the entire tests can be run
**RunCukesTest:** Runner file for cucumber which has the details of the plugins used for reporting, 
paths of feature and step definitions and tests can also be run from here
**Logging :** Logs the information so that we can debug in case of failure. 
At the moment it is logging in console. Due to some dependancy mismatch it is not writing properly to the file.

**Testing**
Ideally, the developed script is tested well on mac machine Chrome/Firefox browser.
So, in case it does not works well then request you to first update your local installed browsers and then try to run the script.

**Test Reports**
Here are a below steps to get a human readable cucumberhtml report.

1) Navigate to project folder where the project is stored locally.
2) Navigate to /target directory.
3) Find the logs inside cucumber-report/cucumber.html directory.
4) Open the file in browser and view the results

**Additional Info:**
**Screenshot on failed tests:** Please find the screen shots of failed test cases here "screenShots.png". Please note that, the screenshot will also be attached to the .html report.


**Bongarcia WebDriver Manager factory:** Consumed this so that we can avoid having the necessity of physical binaries.


**Layers:** Layers like, PageObjects, Test Layer, setup and infra layers are done. Using page object pattern, data driven framework via property files, maven dependency is used to initalize the driver. 
We can design and extend this framework to scale our smoke/sanity/regression based tests.


**Parallel Mode:** Tests can be run "testNg.xml" file in parallel mode, we are passing parallel tage in pom.xml as parallel under maven surefire plugin
which will do this. Also write a small piece of code in cukes file as follows
//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios(){
//                return super.scenarios();
//        }
However I have kept not used it as it is a small set of scenarios.


**Different browser:** Ability to run tests for different browsers by configuring in properties file. This is configured in config properties where we can mention the browser and then accordingly those browser would open up for testing.

************************************************************************************************


**Exercise4:** Automating a WebService


**• Explain the process of how you would approach the task of automating this service.**

1. First identify if this is a Rest API or SOAP API based on that we can select the tools and library
2. Since this is a Rest API , I shall use REST ASSURED library as that is the one for testing REST APIs
3. We can save the expected response in json files so that we can use them for assert
4. For authentication we can use mocking services library like wiremock
5. We need to write the user journeys in an excel or Jira so that we know what we are going to test with the expected output
6. Look for the methods GET, PUT, POST, PATCH, DELETE and make sure depending on the end point the validation is covered
7. Wherever possible we can chain the apis as well
8. Make sure we assert the expected response code, response line, response object wherever applicable
9. Take care pf reporting the results

**• What test cases would you cover?**
**Endpoint for Test:** v2/pet/findByStatus

1. Test if authentication is successful for valid auth token (mock)
2. Test if authentication is un successful for invalid auth token (mock)
3. Test if authentication is successful after auth token expired (mock)
4. For this end point make sure the response status is 200
5. Mock the response body and make sure it is matching with the expected result through assertion
6. Check for the request if instead of and condition if the request been passed as OR then how the response behaves
7. Since it is a GET condition this call should be idempotent, hence set the idempotency key and see if that changes or not
8. Check for the content type assert
9. Test for status available and make sure it is showing 200 status code and it fetches value only for "available"
10. Repeat for other two statuses

**• What libraries would you use?**

1. REST ASSURED
2. JSON SIMPLE
3. APACHE POI
4. JUNIT
5. WIREMOCK

