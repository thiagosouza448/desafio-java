package br.com.util;

import br.com.util.setup.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Base extends DriverManager {

    public Base(WebDriver driver) {
        DriverManager.driver = driver;
    }



    public void waitElement(By locator, Integer time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception ignored) {

        }
    }



    public WebElement findElement(By locator) {
        this.waitElement(locator, 15);
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            return null;
        }
    }

    public void MessageError(String text) {
        Assert.fail(text);

    }

    public List<WebElement> findElements(By locator) {
        this.waitElement(locator, 15);
        try {
            return driver.findElements(locator);
        } catch (Exception e) {
            return null;
        }
    }



    public void EncontrarOpcaoDropDown(String opcao, By locator) throws InterruptedException {
        List<WebElement> DropDown = this.findElements(locator);
        for (WebElement element : DropDown) {
            if (element.getText().trim().equals(opcao)) {
                element.click();
                break;
            }
        }
    }



    public void clickElement(By locator) {
        this.waitElement(locator, 15);
        if (locator != null) {
            if (driver.findElement(locator).isDisplayed()) {
                try {
                    driver.findElement(locator).click();
                } catch (Exception e) {

                    if (driver.findElement(locator).isDisplayed()) {
                        WebElement element = driver.findElement(locator);
                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].click();", element);

                    } else {
                        Assert.fail("Error click");
                    }

                }

            } else {
                Assert.fail("Error click");
            }
        }
    }

    public void fillText(By elemento, String texto) {
        this.waitElement(elemento, 15);
        if (texto == null || texto.equals("")) {
            return;
        }
        this.waitElement(elemento, 15);
        this.findElement(elemento).sendKeys(texto);

    }

    public void uploadFile(By element, String file) {
        findElement(element).sendKeys(file);
    }




    public void verifyUrl(String url) {
        this.waitForPageLoaded();
        String url_verify = driver.getCurrentUrl();
        if (url_verify.contains(url)) {
            System.out.println("Url ok ");
        } else {
            Assert.fail("text does not exist in the url");
        }
    }



    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 100);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


}


