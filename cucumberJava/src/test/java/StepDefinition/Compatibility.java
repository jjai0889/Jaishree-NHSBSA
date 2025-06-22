// src/test/java/StepDefinition/Compatibility.java
package StepDefinition;

import Utility.BaseClass;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Compatibility {

    @Given("I open NHS Jobs site on {string} browser")
    public void openNhsSiteOnBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // Point to your Selenium-managed Firefox binary
                firefoxOptions.setBinary("C:\\Users\\pauls\\.cache\\selenium\\firefox\\win64\\139.0.4\\firefox.exe");

                BaseClass.driver = new FirefoxDriver(firefoxOptions);
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                BaseClass.driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                BaseClass.driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        System.out.println(browser + " launched.");
        BaseClass.driver.manage().window().maximize();
        BaseClass.driver.get("https://www.jobs.nhs.uk/candidate/search");
        System.out.println("Title: " + BaseClass.driver.getTitle());
    }
}
