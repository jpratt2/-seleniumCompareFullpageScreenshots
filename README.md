# Selenium Compare Fullpage Screenshots
*for Java and Maven*


This project is useful for site monitoring on prod for any visual change.  

It uses Selenium 4 to take full-page screenshots in Firefox, and it compares them against a baseline image to generate a diff image for any mismatch.

---
It comes with 2 ready Maven commands:

## Create baseline images and put them in the "expected" folder at the root of the project  
`mvn "-Dtest=A*" test`  

## Run a test and put images in the "observed" folder.  
`mvn "-Dtest=B*" test`  

**If there is any discrepancy between the expected and obverved images, a diff image with the difference highlighted in red will be put in the "diffs" folder.**

URLs for your test can be put in the [src/test/java/URLs.java file](https://github.com/jpratt2/seleniumCompareFullpageScreenshots/blob/master/src/test/java/URLs.java).  
Basic Selenium set up can be put in [src/test/java/Setup.java](https://github.com/jpratt2/seleniumCompareFullpageScreenshots/blob/master/src/test/java/Setup.java)

Syntax for a full-page screenshot:
`Screenshot.fullpage(driver);` where "driver" is a recent Firefox driver

**The file name will be the URL (with forbidden characters replaced by a dash).**
