package br.com.util.pages;

import br.com.util.Base;
import br.com.util.setup.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FormPageTest extends DriverManager {
    private final Base base;

    public FormPageTest(WebDriver driver) {
        DriverManager.driver = driver;
        base = new Base(driver);
    }




    public  void ValidateUrl ()throws InterruptedException {
        base.verifyUrl("http://sampleapp.tricentis.com/101/app.php");
    }


    public  void SelectMake(String make) throws InterruptedException {
        base.EncontrarOpcaoDropDown(make, By.xpath("//select[@id=\"make\"]/option"));
    }


    public void InsertModel(String model, String cylinderCapacity, String enginePerformance) throws InterruptedException {
        base.EncontrarOpcaoDropDown(model, By.xpath("//select[@id=\"model\"]/option"));
        base.fillText(By.id("cylindercapacity"), cylinderCapacity);
        base.fillText(By.id("engineperformance"), enginePerformance);
    }

    public void InsertDate(String date) {
        base.fillText(By.id("dateofmanufacture"), date);
    }

    public void SelectNumberSeats(String numberOfSeats) throws InterruptedException {
        base.EncontrarOpcaoDropDown(numberOfSeats, By.xpath("//select[@id=\"numberofseats\"]/option"));

    }

    public void SelectGHandDriver(String rightHandDrive) {
        switch (rightHandDrive) {
            case "Yes":
                base.clickElement(By.id("righthanddriveyes"));
                break;
            case "No":
                base.clickElement(By.id("righthanddriveno"));
                break;
        }
    }

    public void selectNumberOfSeatsAndFuelTypeAnd(String numberOfSeats, String fuelType) throws InterruptedException {
        base.EncontrarOpcaoDropDown(numberOfSeats, By.xpath("//select[@id=\"numberofseatsmotorcycle\"]/option"));
        base.EncontrarOpcaoDropDown(fuelType, By.xpath("//select[@id=\"fuel\"]/option"));

    }

    public void FillOtherInformation(String payload, String totalWeight, String listPrice, String licensePlateNumber, String annualMileage) {
        base.fillText(By.id("payload"), payload);
        base.fillText(By.id("totalweight"), totalWeight);
        base.fillText(By.id("listprice"), listPrice);
        base.fillText(By.id("licenseplatenumber"), licensePlateNumber);
        base.fillText(By.id("annualmileage"), annualMileage);

    }

    public void ClickInNextStep(String step) throws InterruptedException {
        base.clickElement(By.id(step));
        Thread.sleep(100);
    }

    public void validateCounter(String num, String locator) {
        WebElement counter = driver.findElement(By.xpath(locator));
        Assert.assertEquals(counter.getText(), num);
    }

    public void InsertName(String first, String last) {
        base.fillText(By.id("firstname"), first);
        base.fillText(By.id("lastname"), last);
    }

    public void InsertBirthDate(String date) {
        base.fillText(By.id("birthdate"), date);
    }

    public void selectGender(String gender) {
        switch (gender) {
            case "Male":
                base.clickElement(By.id("gendermale"));
                break;
            case "Female":
                base.clickElement(By.id("genderfemale"));
                break;
        }
    }

    public void acessInsurant() {
        base.clickElement(By.id("enterinsurantdata"));
    }

    public void fillAddress(String street, String country, String zipCode, String city) throws InterruptedException {
        base.fillText((By.id("streetaddress")), street);
        base.EncontrarOpcaoDropDown(country, By.xpath("//*[@id=\"country\"]/option"));
        base.fillText((By.id("zipcode")), zipCode);
        base.fillText((By.id("city")), city);
    }

    public void fillOccupation(String occupation) throws InterruptedException {
        base.EncontrarOpcaoDropDown(occupation, By.xpath("//*[@id=\"occupation\"]/option"));
    }

    public void fillHobbie(String hobbie) {
        List<WebElement> elementList = base.findElements(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label"));
        for (WebElement element : elementList) {
            if (element.getText().trim().equals(hobbie)) {
                element.click();
                break;
            }
        }
    }

    public void fillWebSite(String webSite) {
        String web = "www." + webSite + ".com";
        base.fillText(By.id("website"),web);
    }

    public void UploadPicture() {
        base.uploadFile(By.id("picturecontainer"), "../../test/resources/fixtures/test.png");
    }

    public void acessProduct() {
        base.clickElement(By.id("enterproductdata"));
    }

    public void fillStartDate() {
        String futureDate = LocalDate.now().plusMonths(2).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        base.fillText(By.id("startdate"), futureDate);
    }

    public void selectInsurance(String insurance) throws InterruptedException {
        base.EncontrarOpcaoDropDown(insurance, By.xpath("//*[@id=\"insurancesum\"]/option"));
    }

    public void selectMerit(String merit) throws InterruptedException {
        base.EncontrarOpcaoDropDown(merit, By.xpath("//*[@id=\"meritrating\"]/option"));
    }

    public void selectDamage(String damage) throws InterruptedException {
        base.EncontrarOpcaoDropDown(damage, By.xpath("//*[@id=\"damageinsurance\"]/option"));
    }

    public void selectOptionProduct(String option) {
        switch (option) {
            case "Euro Protection":
                base.clickElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]"));
                break;
            case "Legal Defense Insurance":
                base.clickElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]"));
                break;
        }
    }

    public void selectCourtesy(String courtesy) throws InterruptedException {
        base.EncontrarOpcaoDropDown(courtesy, By.xpath("//*[@id=\"courtesycar\"]/option"));
    }

    public void acessPriceForm() {
        base.clickElement(By.id("selectpriceoption"));
    }

    public void acessPage() {
            base.clickElement(By.id("entervehicledata"));
    }

    public void clickNext(By locator) {
        base.clickElement(locator);
    }

    public void selectPrice(String price) {
        switch (price) {
            case "Silver":
                base.clickElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[1]/span"));
                break;
            case "Gold":
                base.clickElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span"));
                break;
            case "Platinum":
                base.clickElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span"));
                break;
            case "Ultimate":
                base.clickElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[4]/span"));
                break;
        }
    }

    public void fillQuote(String username, String password, String confirmPassword, String comments) {
        Random gerador = new Random();
        int numero = gerador.nextInt(100);
        String email = "thiago" + numero + "@gmail.com";
        String phone = "119521105" + numero;
        this.validateCounter("4", "//*[@id=\"sendquote\"]/span");
        base.fillText(By.id("email"), email);
        base.fillText(By.id("phone"), phone);
        this.validateCounter("3", "//*[@id=\"sendquote\"]/span");
        base.fillText(By.id("username"), username);
        this.validateCounter("2", "//*[@id=\"sendquote\"]/span");
        base.fillText(By.id("password"), password);
        this.validateCounter("1", "//*[@id=\"sendquote\"]/span");
        base.fillText(By.id("confirmpassword"), confirmPassword);
        base.fillText(By.id("Comments"), comments);
    }
}