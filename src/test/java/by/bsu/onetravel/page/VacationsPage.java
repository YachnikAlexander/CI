package by.bsu.onetravel.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.bsu.onetravel.driver.Driver;

public class VacationsPage extends Page {
    @FindBy(xpath = "//*[@id='pkg-advance-options']/div/div/a")
    private WebElement vacationAdvencedOptions;

    @FindBy(id = "rlHtlCar")
    private WebElement hotelAndCarVacation;

    @FindBy(id = "ember885")
    private WebElement hotelNameInput;

    @FindBy(id = "ember887")
    private WebElement carInput;

    @FindBy(xpath = "//article[@class='widget-wrap txt-center']/div/section/ul/li[4]")
    private WebElement vacationsTab;

    public VacationsPage() {
        super();
        PageFactory.initElements(Driver.getDriver(), this);
        openVacationsTab();
    }

    public void pickHotelAndCarVacation() {
        hotelAndCarVacation.click();
    }

    public void openVacationsAdvencedOptions() {
        vacationAdvencedOptions.click();
    }

    public boolean isHotelNameInputVisible() {
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.visibilityOf(hotelNameInput));
        return true;
    }

    public boolean isCarInputVisible() {
        new WebDriverWait(Driver.getDriver(), 5).until(ExpectedConditions.visibilityOf(carInput));
        return true;
    }

    private void openVacationsTab() {
        vacationsTab.click();
    }
}
