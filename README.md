# Selenium Compare Fullpage Screenshots
*for Java and Maven*


This project is useful for site monitoring on prod for any visual change.  

It uses Selenium 4 to take full-page screenshots in Firefox. It compares a baseline image against a current image to generate a diff image with differences highlighted in red. If there is no difference, no diff image is made.

---

It comes with 2 test commands ready for Maven:

## Create baseline images and put them in the "expected" folder at the root of the project  
`mvn "-Dtest=A*" test`  

## Create current images in the "observed" folder and diffs (if any) in the "diffs folder.  
`mvn "-Dtest=B*" test`  

**If there is any discrepancy between the expected and obverved images, a diff image with the difference highlighted in red will be put in the "diffs" folder.**

URLs for your test should be put here: [src/test/java/URLs.java file](https://github.com/jpratt2/seleniumCompareFullpageScreenshots/blob/master/src/test/java/URLs.java).  

Basic Selenium set up: [src/test/java/Setup.java](https://github.com/jpratt2/seleniumCompareFullpageScreenshots/blob/master/src/test/java/Setup.java)

Syntax for a full-page screenshot:
minimal options with project default values:  
`Screenshot.fullpage(driver);` 
Additional options are available


Syntax to compare a full-page screenshot against the corresponding image in the "expected" folder:
minimal options with project default values:  
`Screenshot.compareImage(driver);`
 
An acceptance level can be set with a "pixelThreshold" value. This provides an acceptable difference in pixels that can still be considered a match.  
For example:
`compareImage(driver, 100)`

**The file name will be the URL (with forbidden characters replaced by a dash).**

