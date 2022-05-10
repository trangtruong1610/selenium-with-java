
// run test from cmd with maven
 mvn clean test -Dsurefire.suiteXmlFiles=/path-of-test-suite.xml

// generate alluare report
 allure generate allure-results/ --clean
