Dependencies used:
• Selenium

• WebDriverManager

• Junit5

Prerequisites to run the project:
• JDK 17 (Environment variable)

• Maven (Environment variable)

• IDE (IntelliJ IDEA)

How to run the tests
Open IntelliJ IDEA. Testing was performed in this tool using Selenium 4 automated testing framework, i.e. Selenium testing. As a programming language, Java 17 was used. In the testing was also included Selenium WebDriver. JUnit5 framework and annotations were applied in Selenium for testing and generating test results.

Using the Page Object Model, also known as POM, selected Sauce Demo web pages are created as class files for storing their web elements. Each class file contains only corresponding web page elements. Using these elements, operations on the website are performed under test.

One package consists of the so-called „Page“ classes – Base Page, Login Page, Cart Page, etc. In the other package are the „Tests“ classes for API and UI tests. To remove redundancies, the concept of base class in POM is used. This concept utilizes the Java inheritance OOP property. All the repetitive code is moved to a class, which acts as a parent class for all other classes. This parent class is also known as the base class.

BaseUiTests class holds WebDriver, initialized Page classes, and implicit wait. Also, as Junit5 is used, the @BeforeAll and @AfterAll annotations are added. The „Extends“ keyword is afterward added to every page class. This is the concept of inheritance in Java. This allows the WebDriver object to be available to all the page classes.

The tests are written in the respective test classes. To run the code, first, in the IntelliJ IDEA double-click on the appropriate test class in the test package. Then a new tab opens with code and tests for that class. When we run the tests in IntelliJ IDEA by clicking on the green play button upper in the toolbar (or SHIFT+F10), a respective browser opens and closes. In doing so, the automatic tests we have written are performed. Tests can also be run by clicking on the small green triangles facing right next to the actual tests.

In the Command line tests can be executed using the following commands for example:

mvn test -Dtest="LoginPageTests" mvn test -Dtest="TheSecondUnitTest#whenTestCase2_thenPrintTest2_1"

The report is shown in the console. How many tests have passed or failed, which ones, what and where are the errors, are some of the information in the report.