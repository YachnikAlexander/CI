package by.bsu.onetravel.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.bsu.onetravel.driver.Driver;

public class CarPage extends Page {
    @FindBy(id = "isDropOff")
    private WebElement dropOffInAnotherPlaceButton;

    @FindBy(id = "ember844")
    private WebElement dropOffInput;

    @FindBy(xpath = "//article[@class='widget-wrap txt-center']/div/section/ul/li[3]")
    private WebElement carsTab;

    public CarPage() {
        super();
        PageFactory.initElements(Driver.getDriver(), this);
        openCarsTab();
    }

    private void openCarsTab() {
        carsTab.click();
    }

    public void pickDropOffInAnotherPlaceOption() {
        dropOffInAnotherPlaceButton.click();
    }

    public boolean isDropOffLocationCanBeSet() {
        return dropOffInput.isDisplayed();
    }
}
