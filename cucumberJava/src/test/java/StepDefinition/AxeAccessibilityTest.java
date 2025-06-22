package StepDefinition;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AxeAccessibilityTest {

    WebDriver driver;

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jobs.nhs.uk/candidate/search");
    }

    public void checkAccessibility() throws Exception {
        // Load axe.min.js from resources folder
        InputStream is = getClass().getResourceAsStream("/axe.min.js");
        if (is == null) {
            throw new RuntimeException("axe.min.js not found in resources folder.");
        }

        String script = new Scanner(is, StandardCharsets.UTF_8.name()).useDelimiter("\\A").next();

        // Inject and execute axe
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
        String result = (String) js.executeAsyncScript(
            "var callback = arguments[arguments.length - 1];" +
            "axe.run().then(function(results) {" +
            "    callback(JSON.stringify(results));" +
            "}).catch(function(err) {" +
            "    callback(err);"
            + "});"
        );

        JSONObject json = new JSONObject(result);
        JSONArray violations = json.getJSONArray("violations");

        if (violations.length() > 0) {
            System.out.println("Accessibility violations found:");
            System.out.println(violations.toString(2));
            Assert.fail("Accessibility violations detected");
        } else {
            System.out.println("No accessibility violations found.");
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
