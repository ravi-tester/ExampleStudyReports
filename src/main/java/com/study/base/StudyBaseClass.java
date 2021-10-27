package com.study.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.study.utils.StudyEventListener;
import com.study.utils.StudyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class StudyBaseClass {
    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static StudyEventListener eventListener;
    public static ExtentTest test;
    public static ExtentReports extent;

    /**
     * Constructor of Base class to initilaize the property file
     */

    @BeforeSuite
    public void before() {
        extent = new ExtentReports("test-output\\ExtentReportWithLogs.html", true);
        test = extent.startTest(this.getClass().getSimpleName());

    }

    public StudyBaseClass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\main\\java\\com\\study\\configs\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialise the Driver based on selected driver and get the base_Url
     */
    @SuppressWarnings("deprecation")
    public static void initialization() {
        String browserName = prop.getProperty("browser");
        String operatingSystem = System.getProperty("os.name").toLowerCase();

        if (operatingSystem.contains("windows")) {
            reportLog("Your OS is :" + operatingSystem);
            if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                reportLog("Chrome Driver Initialized.");
            } else if (browserName.equals("FF")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                reportLog("Firefox Driver Initialized.");
            }

        } else if (operatingSystem.contains("mac")) {
            reportLog("Your OS is :" + operatingSystem);
            WebDriverManager.safaridriver().setup();
            reportLog("Safari Driver Initialized.");
        } else {
            reportLog("Could not get your OS info.");
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with
        // EventFiringWebDriver
        eventListener = new StudyEventListener();
        driver = e_driver.register(eventListener);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(StudyUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(StudyUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("base_Url"));
    }

    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }

    // Method for adding logs passed from test cases
    public static void reportLog(String message) {
        test.log(LogStatus.INFO, message);// For extentTest HTML report
        Reporter.log(message);
    }
}
