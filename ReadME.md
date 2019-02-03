Pre-requisites:
1. Eclipse for Mac - 64 bit installed on test terminal
2. Java 10 installed on test terminal
3. Download geckodriver (default) and update the path in class “DriverFactory”, chromedriver and IEDriverServer are optional for running cross-browser testing
4. Install TestNG in Eclipse - http://beust.com/eclipse

Assumptions:
1. Network speed is normal on test terminal
2. Create a new page can be a blank page
3. Page restriction can be any type

Issues:
1. Found some issues on wait for webelements visible/clickable
2. If coincidentally the newly created page has duplicate name with existing, test still passing, need more robust assertions on passing the test