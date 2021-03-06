<h2> Open Browser Using Java Automation </h2>


<h3><b>For Apple Macbook User:</b></h3>

Platform supporting Maven: [IntelliJ IDEA CE](https://www.jetbrains.com/idea/download/download-thanks.html?platform=mac&code=IIC)

1. Create a new Project

2. Choose [Maven](https://en.wikipedia.org/wiki/Apache_Maven#:~:text=Maven%20is%20a%20build%20automation,%2C%20Scala%2C%20and%20other%20languages.&text=Maven%20is%20built%20using%20a,application%20controllable%20through%20standard%20input.)

3. In Project SDK box, make sure you have latest version of java "JDK"

<p align="center">
	<img width="700px" src="OpenBrowser/Image/_1CreateProject.png" align="center"/>
</p>

4. Click Next, and give a name to your project, like "OpenBrowser"

5. Since we are just testing the browsers, we don't need "main" folder inside "src". 

6. Now create a package inside src/java/ and name it "openChrome" then create a class inside it, name it "TestChrome"

7. Create a package inside src/java/ and name it "openFirefox" then create a class inside it, name it "TestFirefox"

8. Create a package inside src/java/ and name it "openSafari" then create a class inside it, name it "TestSafari"


<h4> What is Maven? </h4>

"Maven is a build automation tool used primarily for Java projects. Maven can also be used to build and manage projects written in C#, Ruby, Scala, and other languages.

Maven addresses two aspects of building software: how software is built, and its dependencies. An XML file describes the software project being built, its dependencies on other external modules and components, the build order, directories, and required plug-ins. It comes with pre-defined targets for performing certain well-defined tasks such as compilation of code and its packaging. 

Maven dynamically downloads Java libraries and Maven plug-ins from one or more repositories such as the Maven 2 Central Repository, and stores them in a local cache. Maven projects are configured using a Project Object Model, which is stored in a [pom.xml](https://github.com/kk289/Java-Automation-OpenBrowser/blob/master/OpenBrowser/pom.xml) file."

An example of [pom.xml](https://github.com/kk289/Java-Automation-OpenBrowser/blob/master/OpenBrowser/pom.xml) file looks like: 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>OpenBrowser</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
    </properties>

    <dependencies>

        <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-api -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-api</artifactId>
            <version>3.141.59</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

</project>
```

9. Make sure to setup your "pom.xml" file like above. Just replace your pom.xml file with this [pom.xml](https://github.com/kk289/Java-Automation-OpenBrowser/blob/master/OpenBrowser/pom.xml)


NOTE: 

Make sure you have same version of "selenium-java" and "selenium-api". If they are different version, it could create error and test won't be passed.

<details>
	<summary><h3>Test Chrome Browser : Java Automation</h3></summary>

Let's look at "TestChrome" class:

```
package openChrome;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome {

    @Test
    public void chromeBrowser() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        //WebDriverManager.chromedriver().setup();

        WebDriver wd = new ChromeDriver();
        wd.get("http://www.google.com");

        // Print a Log In message to the screen
        System.out.println("Successfully opened the website");

        // Maximize Browser
        wd.manage().window().maximize();

        // Wait for 5 sec
        Thread.sleep(5000);

        // Close
        wd.quit();
    }
}
```

Note: 

Since my Mac couldnot run selenium.WebDriver, I had to follow manual way. If "selenium.WebDriver" dependency doesn't work for your laptop, we can download the "chromedriver" manually from following website. But before that make sure to check what version of Google Chrome you are using right now. 

- Step 1:

To Check which version of Google Chrome you have:

<p align="center">
	<img width="600px" src="OpenBrowser/Image/googleversion1.png" align="center"/>
	<br>
	<br>
	<img width="600px" src="OpenBrowser/Image/googleversion2.png" align="center"/>
</p> 

- Step 2:

Now you know what version of google chrome you are using, lets download "chromedriver". Download From Here: [Click Here](https://chromedriver.chromium.org/downloads)

Download the ChromeDriver based on your current version of Google Chrome.

<p align="center">
	<img width="600px" src="OpenBrowser/Image/chromedriver1.png" align="center"/>
</p> 

Choose "chromedriver_mac64.zip"

<p align="center">
	<img width="600px" src="OpenBrowser/Image/chromedriver2.png" align="center"/>
</p>

- Step 3: 

Unzip the "chromedriver". Before I go further, take a look at this code from TestChrome class. 

```
System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
```

Like I said before, I had to download chromedriver to run the program. "/usr/local/bin/chromedriver" is the location where I have placed my chromedriver. Or some laptop may have name it as "/user/local/bin/" or "/user/bin/". Make sure where is your bin folder in laptop.

Now either you can simply copy and paste the unzip chromedriver to the OpenBrowser project folder, like this: 

<p align="center">
	<img width="500px" src="OpenBrowser/Image/chromedriver3.png" align="center"/>
</p>


OR,

You can do as I did, placed in system. I strongly recommend you to keep in usr/local/bin/ folder which is inside laptop system. Later you are also going to do same for safari driver too.

<details>
	<summary><b> Click Here to Know How to Store "chromedriver" in /usr/local/bin/ of your Macbook using Terminal</b></summary>

1. Open Terminal

<p align="center">
	<img width="600px" src="OpenBrowser/Image/Terminal1.png" align="center"/>
</p>

2. To Check where you are. Type: ls (It shows all files in current directory.)

<p align="center">
	<img width="600px" src="OpenBrowser/Image/Terminal2.png" align="center"/>
</p>

3. Find the folder where you have stored the "chromedriver" file. Since I have saved in Downloads folder, I will go there. To go to Downloads folder,
Type: cd Downloads and after that type: ls

<p align="center">
	<img width="600px" src="OpenBrowser/Image/Terminal3.png" align="center"/>
</p>

Now you are inside Downloads folder. You can see "chromedriver" file there. 

4. Type: mv chromedriver /usr/local/bin  and then type: ls

<p align="center">
	<img width="600px" src="OpenBrowser/Image/Terminal4.png" align="center"/>
</p>

Now there is no "chromedriver" file. It is already moved to /usr/local/bin/.

5. Type: cd /usr/local/bin and then type: ls

<p align="center">
	<img width="600px" src="OpenBrowser/Image/Terminal5.png" align="center"/>
</p>

Now we are inside /usr/local/bin directory. If you have good eyesight, you can find "chromedriver" file there which is now stored in user system.

That's it. You successful moved "chromedriver" file to /usr/local/bin. 

If you have followed the above step, you can use my entire TestChrome class. No need to change anything. 

</details>

So far, we already setup "pom.xml" file, "TestChrome" class also. Let's Run the TestChrome File. If it is alright, your test class should pass.

<p align="center">
	<img width="700px" src="OpenBrowser/Image/ChromeTestpassed2.png" align="center"/>
	<br>
	<br>
	<img width="700px" src="OpenBrowser/Image/ChromeTestpassed.png" align="center"/>
</p>

<details>
	<summary><b>Check Here: If you got any Error</b></summary>

Apple computers are so strict on running any third-party softwares or file. Here we are using chromedriver file which we downloaded from website. While running TestChrome class, you might have got this error: 

<p align="center">
	<img width="500px" src="OpenBrowser/Image/ChromeError1.png" align="center"/>
</p>

To solve this issue, 

1. First, Go to System Preferences. 

<p align="center">
	<img width="500px" src="OpenBrowser/Image/ChromeError2.png" align="center"/>
</p>

2. Click on "Security & Privacy"

<p align="center">
	<img width="500px" src="OpenBrowser/Image/ChromeError3.png" align="center"/>
</p>

3. Click on "Allow Anyway"

<p align="center">
	<img width="500px" src="OpenBrowser/Image/ChromeError4.png" align="center"/>
</p>

This is how we can able to use "chromedriver" file. Go back to the project and before running the TestChrome class, let's refresh our project by clicking the "Maven" which is on upper right side of our IntelliJ window. 

<p align="center">
	<img width="500px" src="OpenBrowser/Image/ChromeError5.png" align="center"/>
</p>

Now you can see refresh button like recycle type symbol there, click that, and your project is now refreshed.

<p align="center">
	<img width="500px" src="OpenBrowser/Image/ChromeError6.png" align="center"/>
</p>

You can run the TestChrome class. (Click "okay" if any window pop-up) And your test class should be passed now. 

<p align="center">
	<img width="700px" src="OpenBrowser/Image/ChromeTestpassed2.png" align="center"/>
	<br>
	<br>
	<img width="700px" src="OpenBrowser/Image/ChromeTestpassed.png" align="center"/>
</p>

</details>
</details>

---

<details>
	<summary><h3>Test Firefox Browser : Java Automation</h3></summary>

Now, Let's look at "TestFirefox" class. There is not any vast difference between TestChrome and TestFirefox. We just need to change some codes. That's it.

Make sure you have Firefox browser in your laptop. and also we don't need to change anything in "pom.xlm" file. 

<b> TestFirefox </b>

```
package openFirefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFirefox {

    @Test
    public void firefoxBrowser() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();

        WebDriver wd = new FirefoxDriver();

        wd.get("http://www.google.com");

        // Print a Log In message to the screen
        System.out.println("Successfully opened the website");

        // Maximize Browser
        wd.manage().window().maximize();

        // Wait for 5 sec
        Thread.sleep(5000);

        // Close
        wd.quit();
    }
}
```

Here, we are not downloading any firefoxdriver. We can simply import selenium dependency (org.openqa.selenium.firefox.FirefoxDriver) to test Firefox browser in Macbook. 

Now run the "TestFirefox" class. If there is not any error in the code, the firefox test class should be passed.

<p align="center">
	<img width="700px" src="OpenBrowser/Image/FirefoxTestpassed1.png" align="center"/>
	<br>
	<br>
	<img width="700px" src="OpenBrowser/Image/FirefoxTestpassed2.png" align="center"/>
</p>

</details>

---

<details>
	<summary><h3>Test Safari Browser : Java Automation</h3></summary>

This one took more time to setup while comparing with other two browsers. Since Safari is Apple's official browser, we need to pre-setup some steps before we run the program. I am going to post the code for the "TestSafari" class, and after that please follow the steps to run the program successfully.

<b> TestSafari </b>

```
package openSafari;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestSafari {

    @Test
	public void safariBrowser() throws InterruptedException {
        // Instantiate a SafariDriver class.
        System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");

        WebDriver driver = new SafariDriver();

        // Launch Website
        driver.get("http://www.google.com");

        // Print a Log In message to the screen
        System.out.println("Successfully Opened the website");

        // Maximize Browser
        driver.manage().window().maximize();

        // Wait for 5 sec
        Thread.sleep(5000);

        // Close the Browser
        driver.quit();
    }
}
```

We can go to this [website](https://developer.apple.com/documentation/webkit/testing_with_webdriver_in_safari) to know about the testing with webdriver in safari. 

There are bunch of articles saying how to implement the testing with safari browser using extension. But it is old now. Safari does not need any extension now. 

 
<p align="center">
	<img width="600px" src="OpenBrowser/Image/safari1.png" align="center"/>
</p>

Let's get the "safaridriver" first.

- Step 1:

Apple already mentioned in the website that Safari Webdriver is already in the system, we just need to turn it on using terminal. 

Open Terminal 

<p align="center">
	<img width="600px" src="OpenBrowser/Image/Terminal1.png" align="center"/>
</p>

- Step 2:

Type: cd /usr/bin/ and then type: ls

<p align="center">
	<img width="600px" src="OpenBrowser/Image/safari2.png" align="center"/>
</p>

Now find a "safaridriver" and if it is there, type: safaridriver --enable

<p align="center">
	<img width="600px" src="OpenBrowser/Image/safari3.png" align="center"/>
</p>

Enter your computer login password. The "safaridriver" is now turned on. Whereas in TestChrome, we had to download chromedriver and stored in either /usr/local/bin or /usr/bin folder. 

- Step 3:

Now we need to setup Safari Browser before we run the TestSafari class.

Open Safari Browser.

<p align="center">
	<img width="600px" src="OpenBrowser/Image/safari4.png" align="center"/>
</p>

- Step 4:

Click on Safari in menu bar, and choose "Preferences"

<p align="center">
	<img width="600px" src="OpenBrowser/Image/safari5.png" align="center"/>
</p>

- Step 5:

Go to Advanced, and Click on "Show Develop menu in menu bar"

<p align="center">
	<img width="600px" src="OpenBrowser/Image/safari6.png" align="center"/>
</p>

- Step 6:

Once the "Show Develop menu in menu bar" is turned on, we can see "Develop" in menu bar. 

 <p align="center">
	<img width="800px" src="OpenBrowser/Image/safari7.png" align="center"/>
</p>

Click on Develop menu in menu bar, and choose "Allow Remote Automation"

 <p align="center">
	<img width="600px" src="OpenBrowser/Image/safari8.png" align="center"/>
</p>


Let's go back to "TestSafari" class. Before we test the program, make sure we have setproperty correclty. 

```
System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
```

We can run the TestSafari class, and the test class should be passed now. 

<p align="center">
	<img width="700px" src="OpenBrowser/Image/safari9.png" align="center"/>
	<br>
	<br>
	<img width="800px" src="OpenBrowser/Image/safari10.png" align="center"/>
</p>


I hope your program is working now w/o any errors. Thank you for checking out my github! Please give a star if u like it and Fork it if you need.

</details>


