package test.coinmarketcap.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.coinmarketcap.pageobjects.Helper;
import test.coinmarketcap.pageobjects.HomePage;
import test.coinmarketcap.pageobjects.WatchlistPage;

public class MyFrontendStepdefs {
    private WebDriver driver = new ChromeDriver();
    private HomePage homePage;
    private WatchlistPage watchlistPage;
    private Helper helper;

    public MyFrontendStepdefs() {
        this.homePage = new HomePage(driver);
        this.watchlistPage = new WatchlistPage(driver);
        this.helper = new Helper(driver);
    }

    @After
    public void tearDown() {

        if (driver !=null) driver.quit();
    }

    @Given("user opened {} page")
    public void userOpenedHomePage(String pageName) {
        if (pageName.equals("Home")) {
            homePage.open();
        }
    }

    @When("user switches display of cryptocurrencies to {}")
    public void userSwitchesDisplayOfCryptocurrenciesToViewAll(String displayView) {
        if (displayView.equals("View All")) {
            homePage.clickBtnViewAll();
            System.out.println("click view all");
        }
    }

    @Then("{int} cryptocurrencies are displayed in the list")
    public void cryptocurrenciesAreDisplayedInTheList(int rowCount) {
        int actualCount = homePage.countOfCriptocurrencies();
        Assert.assertEquals(rowCount, actualCount);
    }

    @When("user adds between {int} and {int} random cryptocurrencies to watchlist")
    public void userAddsBetweenAndRandomCryptocurrenciesToWatchlist(int start, int end) throws InterruptedException {
        int numberOfCryptocurrencies = helper.getRandomNumberInRange(start, end);

        for (int i = 1; i <= numberOfCryptocurrencies; i++) {
//            add cryptocurrencies to watchlist
            // todo add list of Cryptocurrency objects
//            list.add(homePage.addCryptocurrencyToWatchlist(helper.getRandomNumberInRange(start, end)));
           // homePage.addCryptocurrencyToWatchlist(i);
        }
    }

    @And("opens the watchlist in new browser tab")
    public void opensTheWatchlistInNewBrowserTab()throws InterruptedException{
        watchlistPage.open();
    }

    @Then("selected cryptocurrencies are displayed in the watchlist tab")
    public void selectedCryptocurrenciesAreDisplayedInTheWatchlistTab() {
        // todo asser that list of cryptocur. objects can be found on watchlist tab
    }

    @When("user selects full list option for cryptocurrencies {}")
    public void userSelectsFullListOptionForCryptocurrenciesGroup(String group) {

    }

    @And("user applies filters with {}, {} and {}")
    public void userAppliesFiltersWithMarketCapPriceAndVolume(String marketCap, String price, String volume) {
    }

    @Then("cryptocurrencies that match the filters are displayed")
    public void cryptocurrenciesThatMatchTheFiltersAreDisplayed() {
    }
}
