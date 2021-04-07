# Selenium Compare Fullpage Screenshots
for Java and Maven

This project is useful for site monitoring on prod for any visual change.

It uses Selenium 4 to take full-page screenshots in Firefox, and it compares them against a baseline image to generate a diff image for any mismatch.

It comes with 2 ready-made tests that can be run in Maven:

`mvn "-Dtest=A*" test`

This will create baseline images and put them in the "expected" folder

`mvn "-Dtest=B*" test`

This will create test images and put them in the "observed" folder

If there is any discrepancy, a diff image with the difference highlighted in red will be put in the "diffs" folder.

URLs for your test can be put in the [src/test/java/URLs.java file](https://github.com/jpratt2/seleniumCompareFullpageScreenshots/blob/master/src/test/java/URLs.java).
Basic Selenium set up can be put in [src/test/java/Setup.java](https://github.com/jpratt2/seleniumCompareFullpageScreenshots/blob/master/src/test/java/Setup.java)
