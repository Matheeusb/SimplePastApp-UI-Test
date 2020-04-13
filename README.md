![](src/main/resources/image.png)

Automated test project for the SimplePastApp UI layer.

## Links SimplePastApp 

[Google Play](https://play.google.com/store/apps/details?id=com.simplepastapp)

[Github](https://github.com/brunoklein/SimplePastApp)

## Language and frameworks

- Java 13
- Maven
- Appium
- Lombok
- TestNG

## Execution

#### Preconditons:

- Appium Server be installed.
- Emulator or physical device with SimplePastApp app installed.

#### Command line execution

Using the build plugin maven-surefire-plugin and configuring it with the suiteXmlFiles tag:

```xml
<configuration>
   <suiteXmlFiles>
      <suiteXmlFile>src/test/suites/${suite}.xml</suiteXmlFile>
   </suiteXmlFiles>
</configuration>
```

Use -Dsuite=XmlSuiteName to call the suite.

```shell script
mvn clean test -Dsuite=smoke
```

## Contribute! :beers:
