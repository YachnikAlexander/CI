package by.bsu.onetravel.runner;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import by.bsu.onetravel.driver.Driver;
import by.bsu.onetravel.page.CarPage;
import by.bsu.onetravel.page.IndexPage;
import by.bsu.onetravel.page.VacationsPage;

public class OneTravelTest {
    @Test
    public void ableToHideReturnDateCalendarAfterOneWayChoice() {
        IndexPage indexPage = new IndexPage();
        indexPage.pickOneWayTicketOption();
        Assert.assertFalse(indexPage.isReturnCalendarButtonVisible());
    }

    @Test
    public void preventsInfantsWithoutSeniors() {
        IndexPage indexPage = new IndexPage();
        indexPage.openBookingForm();
        indexPage.addLapInfant();
        indexPage.removeAdult();
        indexPage.selectRequest();
        Assert.assertTrue(indexPage.isWarningVisible());
    }

    @Test
    public void isAbleToPreventsMoreInfantsThanAdults() {
        IndexPage indexPage = new IndexPage();
        indexPage.openBookingForm();
        indexPage.addLapInfant();
        indexPage.addLapInfant();
        indexPage.selectRequest();
        Assert.assertTrue(indexPage.isWarningVisible());
    }

    @Test
    public void allowsReturnPlaneFromAnotherPlace() {
        IndexPage indexPage = new IndexPage();
        indexPage.openAdvencedOptionsForm();
        indexPage.pickToReturnFromAnotherAirport();
        Assert.assertTrue(indexPage.isReturnAirportInputVisible());
    }

    @Test
    public void preventsSameFromAndToPlace() {
        IndexPage indexPage = new IndexPage();
        indexPage.setDestinationAirport("VTB - Vitebsk, Belarus");
        indexPage.selectRequest();
        Assert.assertTrue(indexPage.isWarningVisible());
    }

    @Test
    public void limitMaxAllowedBookingQuantity() {
        IndexPage indexPage = new IndexPage();
        indexPage.openBookingForm();
        for (int i = 0; i < 8; i++) {
            indexPage.addAdult();
        }
        indexPage.addLapInfant();
        indexPage.selectRequest();
        indexPage.isWarningVisible();
    }

    @Test
    public void allowsChoiceFromMultipleDestinations() {
        IndexPage indexPage = new IndexPage();
        indexPage.chooseMultipleDestinationFlights();
        Assert.assertTrue(indexPage.isSecondFromInputVisible());
    }

    @Test
    public void allowsDifferentCarDropOffPlace() {
        CarPage page = new CarPage();
        page.pickDropOffInAnotherPlaceOption();
        Assert.assertTrue(page.isDropOffLocationCanBeSet());
    }

    @Test
    public void isAbleToBookFlightAndHotelForVacation() {
        VacationsPage page = new VacationsPage();
        page.openVacationsAdvencedOptions();
        Assert.assertTrue(page.isHotelNameInputVisible());
    }

    @Test
    public void isAbleToBookHotelAndCarVacation() {
        VacationsPage page = new VacationsPage();
        page.pickHotelAndCarVacation();
        page.openVacationsAdvencedOptions();
        Assert.assertTrue(page.isCarInputVisible());
    }

    @AfterClass
    public void closeDriver() {
        Driver.closeDriver();
    }
}