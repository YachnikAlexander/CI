package by.bsu.onetravel.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.bsu.onetravel.driver.Driver;

public class IndexPage extends Page {
    @FindBy(xpath = "//label[@id='owFlight']")
    private WebElement oneWayRadio;

    @FindBy(id = "mcFlight")
    private WebElement MultipleDestinationsRadio;

    @FindBy(id = "departCalendar_0")
    private WebElement departureDateCalendarButton;

    @FindBy(id = "arrivalCalendar_0")
    private WebElement returnDateCalendarButton;

    @FindBy(xpath = "//label[@for='totalTraveler']")
    private WebElement bookingFormButton;

    @FindBy(xpath = "//input[@value='Search Now']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@data-ember-action='729']")
    private WebElement removeAdultButton;

    @FindBy(xpath = "//button[@data-ember-action='730']")
    private WebElement addAdultButton;

    @FindBy(xpath = "//button[@data-ember-action='742']")
    private WebElement addLapInfantButton;

    @FindBy(xpath = "//ul[@class='error-msg__list']")
    private WebElement warning;

    @FindBy(id = "diffAirportCheckId")
    private WebElement chooseToReturnFromAnotherAirport;

    @FindBy(id = "ember1011")
    private WebElement returnAirportFromInput;

    @FindBy(id = "ember1018")
    private WebElement SecondFromInput;

    @FindBy(id = "ember680")
    private WebElement destinationAirportInput;

    @FindBy(xpath = "//a[@data-target='#search-opt-flight']")
    private WebElement advencedOptionsButton;

    public IndexPage() {
        super();
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void pickOneWayTicketOption() {
        oneWayRadio.click();
    }

    public boolean isReturnCalendarButtonVisible() {
        return returnDateCalendarButton.isDisplayed();
    }

    public void openBookingForm() {
        bookingFormButton.click();
    }

    public void addLapInfant() {
        addLapInfantButton.click();
    }

    public void removeAdult() {
        removeAdultButton.click();
    }

    public void addAdult() {
        addAdultButton.click();
    }

    public void selectRequest() {
        searchButton.click();
    }

    public void pickToReturnFromAnotherAirport() {
        new WebDriverWait(Driver.getDriver(), 5)
                .until(ExpectedConditions.visibilityOf(chooseToReturnFromAnotherAirport));
        chooseToReturnFromAnotherAirport.click();
    }

    public void openAdvencedOptionsForm() {
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.visibilityOf(advencedOptionsButton));
        advencedOptionsButton.click();
    }

    public void chooseMultipleDestinationFlights() {
        MultipleDestinationsRadio.click();
    }

    public void setDestinationAirport(String destination) {
        destinationAirportInput.sendKeys(destination);
    }

    public boolean isReturnAirportInputVisible() {
        return returnAirportFromInput.isDisplayed();
    }

    public boolean isSecondFromInputVisible() {
        return SecondFromInput.isDisplayed();
    }

    public boolean isWarningVisible() {
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.visibilityOf(warning));
        return true;
    }
}