package Extents2;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import com.kms.katalon.core.configuration.RunConfiguration

public class Extent
{
    ExtentReports extent;

    @BeforeTest
    public void config() {
         String path = System.getProperty("RunConfiguration.getProjectDir()")+"ExtentReports.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Venkata Sambaraju");
    }

    @Test
    public void initialDemo() {
        ExtentTest test = extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver", "/Users/venkatasambaraju/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");

        //test.addScreenCaptureFromBase64String()
       // test.fail("Results do not match");
       test.pass("results passed");
        System.out.println(driver.getTitle());
         extent.flush();
    }

}
