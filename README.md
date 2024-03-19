### Solution Overview and Execution Guide:

The provided solution furnishes a Java-based automation framework meticulously crafted for web testing endeavors. Alongside Selenium WebDriver and TestNG, it provides a robust structure for test execution and management. Below, find an overview of the solution components and instructions for execution:

#### 1. Components Overview:

##### 1.1. BaseTest Class:
- **Purpose:** Establishes the groundwork for test execution, encompassing setup and teardown operations.
- **Features:** Inherits `file_prop_utlities` for efficient properties file handling.
- **Methods:**
  - `setup(browser)`: Initializes WebDriver based on the specified browser parameter.
  - `terminate()`: Closes the WebDriver instance post-test execution.
  

##### 1.2. Test Class:
- **Objective:** Hosts test methods for executing diverse test scenarios.
- **Methods:**
  - `testcaseone(keyword)`: Executes a test case by conducting a search operation and verifying results across multiple pages.
- **Data Provisioning:**
  - `dpMethod()`: Supplies test data for the `testcaseone` method.
  

##### 1.3. Listeners Class:
- **Purpose:** Implements TestNG's `ITestListener` interface, adeptly managing test events.
- **Integration:** Leverages `test_utilities` for seamless screenshot capture utilities.
- **Functionalities:**
  - `onTestStart(result)`: Captures a screenshot at the test's initiation.
  - `onTestFailure(result)`: Captures a screenshot upon test failure.
  - `onTestSuccess(result)`: Captures a screenshot on test success.

##### 1.4. File_prop_utilities Class:
- **Description:** This class provides utilities for reading values from properties files.
- **Methods:**
  - `getValue(String key, String path)`: Retrieves the value associated with the specified key from the properties file.
  
  
##### 1.5. Test_utilities Class:
- **Description:** This class provides utilities for taking screenshots using Selenium WebDriver. It extends the BaseTest class to inherit necessary functionalities.
- **Methods:**
  - `getSnapshot(String ScreenShot_Name)`: Captures a screenshot and saves it with the provided name and timestamp.


##### 1.6. TestNG XML Suite Configuration:
- **Configuration:** Defines the TestNG suite to execute tests across different browsers.
- **Execution:**
  - `ChromeTest`, `EdgeTest`, `FirefoxTest`: Parameterized tests catering to Chrome, Edge, and Firefox browsers, respectively.

#### 2. Execution Guide:

To execute the tests using the provided TestNG XML suite file (`testng.xml`), follow these steps:

1. Ensure you have the necessary dependencies installed (e.g., Selenium WebDriver, TestNG).
2. Open the TestNG XML suite file (`testng.xml`) in your preferred IDE or text editor.
3. Run the suite file (`testng.xml`) as a TestNG suite.


#### 3. Parameter Customization:

To customize test execution parameters (e.g., browser selection), modify the TestNG XML suite file (`testng.xml`). Specifically, adjust the `browser` parameter value within each `<test>` tag to specify the desired browser for test execution. Supported values include `chrome`, `edge`, and `firefox`.
#### 4. Report Generation:

Upon test execution, the TestNG framework will automatically generate a detailed HTML report. The report will be located in the `test-output` folder and named `index.html`. It provides comprehensive insights into test results, including passed, failed, and skipped tests, along with associated screenshots and logs.

#### Note:
This project is already structured as a Maven project. Ensure you have the necessary dependencies installed, such as Selenium WebDriver and TestNG, as they are managed by Maven and specified in the `pom.xml` file.
