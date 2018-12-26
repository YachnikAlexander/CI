package by.bsu.onetravel.page;

import org.openqa.selenium.WebDriver;

import by.bsu.onetravel.driver.Driver;

public class Page {
    private WebDriver driver;

    protected Page() {
        this.driver = Driver.getDriver();
        driver.get("https://www.onetravel.com/");
    }
}
