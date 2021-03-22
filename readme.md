**Leave application using Rest Assured and TestNG.**

The framework is for created for Validating API's of user blog.

**Project Description:**

All API Endpoint and respective responses are available in `api` package.

`clients` will interact with Endpoints and return the deserialized response objects which can be used in tests.

`report` package contains listners and report configurations.

assertions are mostly inside `assertions` package keeping the code more readable and also taking into account that responses may be needed to validate multiple times in tests in different stages.


**Getting Started**

**`Tech Stack`**

JAVA 8 as the programming language for writing test code.

RestAssured and TestNG as the frameworks.

Extend Reports for test reporting.

**`Setup:`**

Install Maven
Install TestNG
IDE
Intellij

**`Deployment Instruction`**`

Clone the repository or download the zip and Unzip the project into local Directory.
Import the Project folder into the Intellij.

**`Running Tests`**


You can run the test direclty by right click on Test from src/test/java/tests, select Run As option and click on TestNG Test.

You can run test using testNG.xml by Right click on testNG.xml , select Run testNG.xml.

**`Report Generation`**

All the reports will be genrated under /ExtendReports post execution
