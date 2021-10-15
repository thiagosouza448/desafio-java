package br.com.util.steps;


// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import br.com.util.setup.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Hooks extends DriverManager {

    private Boolean localRun = true;


    @Before
    public void before(Scenario scenario) throws Exception {
        //Create the driver instance, set the current driver instance and open the specified URL in the selenium properties


        if (this.localRun) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments(new String[]{"--headless"});
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.media_stream_mic", 2);
            prefs.put("profile.default_content_setting_values.media_stream_camera", 2);
            prefs.put("profile.content_settings.exceptions.media_stream_camera.'https://<oursite>:443,'.setting", "1");
            prefs.put("profile.content_settings.exceptions.media_stream_mic.'https://<oursite>:443,'.setting", "1");
            options.setExperimentalOption("prefs", prefs);

            options.addArguments(new String[]{"window-size=1920,1080"});
//            options.addArguments(new String[]{"--headless"});

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\thiag\\chromedriver\\chromedriver.exe");
//            System.setProperty("base", "chrome");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();


            driver.get("http://sampleapp.tricentis.com/101/app.php");
//            Thread.sleep(10000);


        } else {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("use-fake-device-for-media-stream");
            options.addArguments("use-fake-ui-for-media-stream");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_     version", "90.0");
            caps.setCapability("resolution", "1920x1080");
            caps.setCapability("name", "thiagosouza6's First Test");
            caps.setCapability("browserstack.user", "thiagosouza_hGQRcz");
            caps.setCapability("browserstack.key", "o2bQhfnHAFkNWcRXEYBY");
            driver = new RemoteWebDriver(new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
            driver.get("https://web.pre.gruposuperdigital.com/login");

        }

    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }


}
