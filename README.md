## Sample project using Spring MVC, pure Java (no XML) configuration, Gradle, running in STS

This is a tiniest bootstrap of a project that uses:

* Spring MVC (tested with Spring 4.0.6.RELEASE)
* Java-based configuration (no XML config files)
* Gradle (tested with 2.0)
* loads into STS (tested with 3.6.1)
* runs inside embedded TC server in STS (tested with STS 3.0 using tc Server 8.0.9)
* runs on Tomcat (tested with 8.0.11)
* Java (tested with Java 8)

The goal was to create minimal (6 files, including this README) set of files that could be used to start a dynamic web project in STS. There is literally no content here. You can use myriad of other tutorials to add content. This is almost like an empty archetype to get started with Spring MVC using Gradle in STS.

### How to load and run the project

* Get the project files
  * either using `git clone` from here (you should), or
  * get the zip file
* Make sure you have Spring STS installed
  * Make sure the tc Server is configured (in the Servers view) and starts up without errors
* Install Gradle support into STS - follow https://github.com/spring-projects/eclipse-integration-gradle
  * If your **IDE Extensions** opens up empty, you may need to configure your proxy settings. Go to Window -> Preferences -> General -> Network Connections. Update proxy settings or try choosing **Direct** provider.
* it is not necessary to run `gradle eclipse` prior to the import (the import wizard does it on its own).
* In STS, choose File -> Import -> Gradle -> Gradle Project to open the wizard:
  * navigate to the project directory (that contains build.gradle)
  * Do not forget to click the **Build Model** button. It may take a few minutes (downloading gradle, running the build, and building the model).
  * leave the **Run before** and **Enable Dependency Management** options checked
  * click **Finish**.
* Verify the project got loaded, it has globe icon (Web project) and G icon (gradle). There should be no errors or warnings.
* Right-click on the project, chose Run As -> Run on Server
* If everything went fine, STS should open http://localhost:8080/spring-mvc-noxml-gradle/ and you should see *Hello World*. If not, good luck debugging.

#### Further reading:

* https://github.com/spring-projects/eclipse-integration-gradle/wiki/Gradle-Import-Wizard. It explains how Gradle import works. Pretty useful.
* http://geowarin.github.io/2013/01/23/complete-example-of-a-spring-mvc-3-2-project/. It has more content and how-to samples.

### Issues and further steps

* The Gradle Import Wizard uses its own version of Gradle wrapper. So even if you install your own 'native' Gradle runtime, the import wizard forces its own wrapper (2.0 as of September 2014)
* The Gradle Import Wizard documentation claims that **Enable Dependency Management** option works for pure Java project only. For this super simple project it worked but you may need to disable it for real (more complex) project - read on it and see the implications (your .classpath files become location-spaecific and should not be checked in your version control system).
* The `gradle eclipse` task claims to do the merging, so you should be able to rerun it even after tweaking the Eclipse metadata files. Still, it is recommended to not rely on it. If possible, invest in customizing the generation (by leveraging the *Run before* and *Run after* hooks) and do not check in the metadata files.
* The Gradle_Import-Wizard link explains things using spring-security project. Clone the files and see how a pretty complex gradle build files look; they even massage the generated Eclipse metadata files.
