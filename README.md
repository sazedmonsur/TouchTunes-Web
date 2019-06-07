# TouchTunes-Web

An automated framework is created following page object model design pattern.

Environment Requirements:

1. Please make sure latest version of JDK is installed and Enviroenemnt variable is configured
2. Please install maven plugin on your eclipse
3. Configure the Chrome Driver on your machine C:\\chromedriver_win32\\
4. Configure the log file on your machine C:\Log\SearchResults.txt

Task 1:

Follow the page oriented approach, write a automation test that checks the following
scenario: (Page Class: GoogleSearchPages.java, TestClass: VerifyGoogleSearch.java)
- Go to Google
- Search for “Touchtunes”
- Make sure that correct result are returned

Task 2:
Get all the element http://www.touchtunes.com/about/press/ which contains “href”
attribute and contains “touchtunes”, then output the result to a file (eg. result.log, file
format is not limit to .log) (Page Class: PressPage.java, TestClass: PressSmokeTests.java)

Task 3:
Check all the link inside result file and check if there is any broken link, if exist, print the
broken links in the console (Page Class: PressPage.java, TestClass: PressSmokeTests.java)
