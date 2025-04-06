# Luminor home task

# Prerequisites
Install Java JDK 21, Gradle 8.12 and as an IDE I recommend to use IntelliJ Idea Community Edition it is free.

# Structure
Each page has its own class, named the same way as a page here is an example *src/main/java/pages/ImdbMainPage.java*
There are defined elements related to the page, buttons, fields and etc.

Steps are defined in separate classes which are also named in consistency with page name.
For example *src/test/java/testSteps/ImdbMainPageSteps.java*

Each step with cucumber annotation is attached to the feature classes
which also has consistent naming *src/test/resources/features/Search.feature*

# Test execution
In the build.gradle and in the *src/test/java/runner/TestRunner.java* is presented *'--tags'* argument.
Defining value of this argument according to tag from feature classes you can choose which tests to execute.
Just mention correct test tag which you can find for example in the *src/test/resources/features/Search.feature*
you also able to define multiple tags.
Also in build.gradle file you are able to select run tests in parallel or not by commenting or uncommenting *'--threads'*
argument.

To run the tests locally on you machine you have multiple ways:

1. Go to *src/test/java/runner/TestRunner.java* class and just click play button.

2. Open Windows Powershell terminal in IntelliJ Idea and execute *gradle testSuite* command.
   This command will execute tests with local gradle installed on your machine.

3. Open Windows Powershell terminal in IntelliJ Idea and execute *./gradlew testSuite* command.
   This command will execute tests with gradle wrapper from the project, and you don't need to have gradle installed on your machine.

# Reporting
1. If you executed tests from *src/test/java/runner/TestRunner.java* or by using *gradle testSuite* command
   then *Cucumber reports* are generated in *target/cucumber-report.html*, and you can open them in any browser.
   Just open the file and IntelliJ Idea will suggest it for you.

2. If you have executed tests via *src/test/java/runner/TestRunner.java* or by using *gradle testSuite*,
   and then you want to generate *Allure reports*, then you can do it by the next steps:

Use the *Gradle* tab on the right side of IntelliJ Idea window, expand *luminortask* >
*Tasks* > *verification* > and double-click on *allureReport* and wait until message appears in the console
saying that *Report successfully generated*.

In the same tab double-click on *allureServe* and reports will be opened in main browser.

Also, you can use the *gradle allureReport* and or *gradle allureServe* commands in terminal to generate and open the *Allure reports*.

In the project *Allure reports* are saved in */build/reports/allure-report* folder, to open them just double-click on *index.html*
and *IntelliJ Idea* will offer to you the browser to open the reports.

# GitHub Actions test execution and reporting
1. Go to project source page: https://github.com/HowlingWind89/luminortask

2. Click *Actions* on the header.

3. Page with the workflows is opened.

4. Select a workflow which you want to execute, at the moment there is presented *Luminor testSuite* workflow.

5. Click on menu button *Run workflow* in opened menu click button *Run workflow*.

6. New process will appear in the list.

7. Click on the new appeared process and detailed page will be opened.

8. In detailed page you can see the jobs which are executing at the moment.

9. Clicking on the job you will see the detailed logs, which build steps and tests are running at the moment and other
   information.

10. After the execution you can click on *Summary* button, page with the execution results is opened and reports can
    be found in the *Artifacts*, they are presented there as a .zip archives, you can download them and open on your computer.