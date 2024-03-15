
Note:
=====
Amazon Search Tests

<h2>Getting Started</h2>

<br>Project is a maven project </br>
<br>Install mvn in your local machine </br>
<br>Install Java </br>
<br>Install git and Intellij/any IDE</br>
<br>Install the gherkin plugin for IDE </br>

<br>Check out this project </br>
<br>Build your project </br>



<h2>Run your test with Cucumber</h2>
```mvn clean test -Pcucumber ```

<br>You can right click on CucumberTestRunner and run the BDD test .</br>
<br>Test results and Logs  will be available at test out put folder.</br>


<h2>Project Structure</h2>

<br>Tests and Functions are separated.</br>
<br>All tests available in test package</br>
<br>Package structure</br>

````
├── README.md
├── pom.xml
├── src
|  ├── main
|  |  ├── java
|  |  |  └── org
|  |  |     └── ubs
|  |  |        ├── common
|  |  |        |  ├── BrowserTypes.java
|  |  |        |  └── GlobalConstants.java
|  |  |        ├── data
|  |  |        |  └── SearchedItem.java
|  |  |        ├── functions
|  |  |        |  ├── AmazonFilters.java
|  |  |        |  ├── AmazonHome.java
|  |  |        |  └── FunctionBase.java
|  |  |        ├── pages
|  |  |        |  ├── AmazonHomePage.java
|  |  |        |  ├── AmazonResultPage.java
|  |  |        |  ├── DriverBase.java
|  |  |        |  └── SideFilterPanel.java
|  |  |        └── utils
|  |  |           ├── DriverSetupUtil.java
|  |  |           └── PropertyReader.java
|  |  └── resources
|  |     ├── config.properties
|  |     └── properties
|  |        └── log4j.properties
|  └── test
|     ├── java
|     |  └── org
|     |     └── ubs
|     |        ├── AmazonSearchTest.java  ==> Pure Test NG Test
|     |        ├── TestBase.java
|     |        ├── definitions   ==> Cucumber Related Definations
|     |        |  ├── AfterActions.java
|     |        |  └── AmazonSearchSteps.java 
|     |        └── testRunner
|     |           └── CucumberTestRunner.java  ==> Main test runner file to  run BDD tests
|     ├── regression.xml
|     └── resources
|        ├── extent.properties
|        ├── features
|        |  └── AmazonSearch.feature
|        └── spark-config.xml
└── test_output                                 ==> All Test related outputs
   ├── extendreport.html
   ├── htmlreport.html
   └── logs
      ├── app_Thu_Mar_14_16_48_52_GMT_2024_log.txt
      └── app_Thu_Mar_14_16_50_07_GMT_2024_log.txt

````

<h2>Configurations</h2>
<br>Open config.properties file resources folder</br>
```
browser.type=chrome
```

<h2>Trouble Shoot on Browser Issue </h2>
<br>I have used web driver manager for chrome driver or any web driver initialization </br>
<br>Latest web driver manager has some issue</br>
<br>If you face driver issue while running the project please do the following</br>
Download the zip file from the below suitable URLs.

Windows - https://storage.googleapis.com/chrome-for-testing-public/121.0.6167.184/win64/chromedriver-win64.zip

Mac - https://storage.googleapis.com/chrome-for-testing-public/121.0.6167.184/mac-x64/chromedriver-mac-x64.zip
<br>Extract it and replace the chromedriver.exe in 114 folder on the below location. (Please delete the existing chromedriver.exe in 114 folder</br>
<br>Windows Location</br>
```C:\Users\{Your User Name}\.cache\selenium\chromedriver\win32\114.0.5735.90 ```
<br>Mac Location</br>
```/Users/{Your User Name}/.cache/selenium/chromedriver/mac64 ```





