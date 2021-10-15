package br.com.util.steps;

import br.com.util.pages.FormPageTest;
import br.com.util.setup.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


public class LoginSteps extends DriverManager {


    private final FormPageTest loginPage;

    public LoginSteps() {
        loginPage = new FormPageTest(driver);
    }


    @Given("access page")
    public void accessPage() throws InterruptedException {
        loginPage.acessPage();
        loginPage.validateCounter("12", "//*[@id=\"entervehicledata\"]/span");
    }

    @And("select the make {string}")
    public void selectTheMake(String make) throws InterruptedException {
        loginPage.SelectMake(make);
        loginPage.validateCounter("11", "//*[@id=\"entervehicledata\"]/span");
    }

    @When("select  {string} and fill {string} {string}")
    public void selectAndFill(String model, String CylinderCapacity, String EnginePerformance) throws InterruptedException {
        loginPage.InsertModel(model, CylinderCapacity, EnginePerformance);
        loginPage.validateCounter("8", "//*[@id=\"entervehicledata\"]/span");
    }

    @And("fill date {string}")
    public void fillDate(String date) {
        loginPage.InsertDate(date);
        loginPage.validateCounter("7", "//*[@id=\"entervehicledata\"]/span");
    }

    @And("select {string}")
    public void select(String NumberOfSeats) throws InterruptedException {
        loginPage.SelectNumberSeats(NumberOfSeats);
        loginPage.validateCounter("6", "//*[@id=\"entervehicledata\"]/span");
    }

    @And("select RightHandDrive {string}")
    public void selectRightHandDrive(String RightHandDrive) {
        loginPage.SelectGHandDriver(RightHandDrive);
    }

    @And("select number of seats and fuel type {string} and {string}")
    public void selectNumberOfSeatsAndFuelTypeAnd(String NumberOfSeats, String FuelType) throws InterruptedException {
        loginPage.selectNumberOfSeatsAndFuelTypeAnd(NumberOfSeats, FuelType);
        loginPage.validateCounter("4", "//*[@id=\"entervehicledata\"]/span");
    }

    @And("I fill in the other information  {string}  {string}  {string}  {string}  {string}")
    public void iFillInTheOtherInformation(String Payload, String TotalWeight, String ListPrice, String LicensePlateNumber, String AnnualMileage) {
        loginPage.FillOtherInformation( Payload,  TotalWeight,  ListPrice,  LicensePlateNumber,  AnnualMileage);
        loginPage.validateCounter("0", "//*[@id=\"entervehicledata\"]/span");
    }

    @Given("access insurant data form")
    public void accessInsurantDataForm() {
        loginPage.acessInsurant();
    }

    @And("fill {string} name and {string} name")
    public void fillNameAndName(String first, String last) {
        loginPage.InsertName(first, last);
        loginPage.validateCounter("5", "//*[@id=\"enterinsurantdata\"]/span");
    }

    @When("fill {string}")
    public void fill(String date) {
        loginPage.InsertBirthDate(date);
        loginPage.validateCounter("4", "//*[@id=\"enterinsurantdata\"]/span");
    }

    @And("select {string} valid")
    public void selectValid(String gender) {
        loginPage.selectGender(gender);
    }

    @And("fill address {string} {string} {string} {string}")
    public void fillAddress(String street, String country, String zipCode, String city) throws InterruptedException {
         loginPage.fillAddress(street, country, zipCode, city);
         loginPage.validateCounter("2", "//*[@id=\"enterinsurantdata\"]/span");
    }

    @And("fill {string}  {string}")
    public void fill(String occupation, String hobbie) throws InterruptedException {
        loginPage.fillOccupation(occupation);
        loginPage.fillHobbie(hobbie);
        loginPage.validateCounter("0", "//*[@id=\"enterinsurantdata\"]/span");
    }

    @And("fill website {string}")
    public void fillWebsite(String web) {
        loginPage.fillWebSite(web);
    }

    @And("make upload file")
    public void makeUploadFile() {
        loginPage.UploadPicture();
    }

    @Then("click in the next {string}")
    public void clickInTheNext(String step) throws InterruptedException {
        loginPage.ClickInNextStep(step);
    }

    @Given("access product data form")
    public void accessProductDataForm() {
        loginPage.acessProduct();
        loginPage.validateCounter("6", "//*[@id=\"enterproductdata\"]/span");
    }

    @And("fill start date")
    public void fillStartDate() {
        loginPage.fillStartDate();
        loginPage.validateCounter("5", "//*[@id=\"enterproductdata\"]/span");
    }

    @And("select {string} {string} {string}")
    public void select(String insurance, String merit, String damage) throws InterruptedException {
        loginPage.selectInsurance(insurance);
        loginPage.validateCounter("4", "//*[@id=\"enterproductdata\"]/span");
        loginPage.selectMerit(merit);
        loginPage.validateCounter("3", "//*[@id=\"enterproductdata\"]/span");
        loginPage.selectDamage(damage);
        loginPage.validateCounter("2", "//*[@id=\"enterproductdata\"]/span");
    }

    @And("select {string} product")
    public void selectProduct(String option) {
        loginPage.selectOptionProduct(option);
        loginPage.validateCounter("1", "//*[@id=\"enterproductdata\"]/span");
    }

    @When("select {string} car")
    public void selectCar(String courtesy) throws InterruptedException {
        loginPage.selectCourtesy(courtesy);
        loginPage.validateCounter("0", "//*[@id=\"enterproductdata\"]/span");
    }

    @Given("access price data form")
    public void accessPriceDataForm() {
        loginPage.acessPriceForm();
    }

    @And("fill in the data on the first form")
    public void fillInTheDataOnTheFirstForm() throws InterruptedException {
        loginPage.SelectMake("Ford");
        loginPage.InsertModel("Scooter", "19", "21");
        loginPage.InsertDate("08/12/1992");
        loginPage.SelectNumberSeats("1");
        loginPage.SelectGHandDriver("Yes");
        loginPage.selectNumberOfSeatsAndFuelTypeAnd("1", "Diesel");
        loginPage.FillOtherInformation( "322",  "2323",  "2333",  "22",  "222");
        loginPage.clickNext(By.id("nextenterinsurantdata"));
    }

    @And("fill in the data on the second form")
    public void fillInTheDataOnTheSecondForm() throws InterruptedException {
        loginPage.InsertName("Thiago", "Souza");
        loginPage.InsertBirthDate("04/10/2000");
        loginPage.selectGender("Male");
        loginPage.fillAddress("Rua Miller", "Brazil", "03011011", "Sao Paulo");
        loginPage.fillOccupation("Farmer");
        loginPage.fillHobbie("Skydiving");
        loginPage.fillWebSite("thiagoteste");
        loginPage.UploadPicture();
        loginPage.clickNext(By.id("nextenterproductdata"));
    }

    @And("fill product data")
    public void fillProductData() throws InterruptedException {
        loginPage.fillStartDate();
        loginPage.selectInsurance("35.000.000,00");
        loginPage.selectMerit("Bonus 1");
        loginPage.selectDamage("Partial Coverage");
        loginPage.selectOptionProduct("Euro Protection");
        loginPage.selectCourtesy("No");
        loginPage.clickNext(By.id("nextselectpriceoption"));
    }

    @And("select {string} form")
    public void selectForm(String price) {
        loginPage.selectPrice(price);
        loginPage.clickNext(By.id("nextsendquote"));
    }

    @When("send quote with data {string} {string} {string} {string}")
    public void sendQuoteWithData(String username, String password, String confirmPassword, String comments) {
        loginPage.fillQuote(username, password, confirmPassword, comments);
    }

    @Then("then send successfully")
    public void thenSendSuccessfully() {
        loginPage.validateCounter("0", "//*[@id=\"sendquote\"]/span");
        loginPage.clickNext(By.id("sendemail"));
    }
}
