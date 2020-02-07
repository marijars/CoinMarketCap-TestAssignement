package test.coinmarketcap.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.coinmarketcap.data.Cryptocurrency;
import test.coinmarketcap.pageobjects.*;

import java.util.ArrayList;
import java.util.List;

public class MyFrontendStepdefs {
    private WebDriver driver = new ChromeDriver();
    private HomePage homePage;
    private WatchlistPage watchlistPage;
    private Helper helper;
    private TableMenuOptions tableMenu;
    private FilterCryptocurrencies filter;

    List<Cryptocurrency> listOfCryptocurrencies = new ArrayList<Cryptocurrency>();

    public MyFrontendStepdefs() {
        this.homePage = new HomePage(driver);
        this.watchlistPage = new WatchlistPage(driver);
        this.helper = new Helper(driver);
        this.tableMenu = new TableMenuOptions(driver);
        this.filter = new FilterCryptocurrencies(driver);
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
        }
    }

    @Then("{int} cryptocurrencies are displayed in the list")
    public void cryptocurrenciesAreDisplayedInTheList(int rowCount) {
        int actualCount = homePage.numberOfListedCryptocurrencies();
        Assert.assertEquals(rowCount, actualCount);
    }

    @When("user adds between {int} and {int} random cryptocurrencies to watchlist")
    public void userAddsBetweenAndRandomCryptocurrenciesToWatchlist(int start, int end) throws InterruptedException {
        int numberOfCryptocurrencies = helper.getRandomNumberInRange(start, end);
        List<Integer> randomIDs = new ArrayList<Integer>();

        // generate a list of random IDs, which cryptocurrencies will be add to watchlist
        int i = 0;
        do{
            randomIDs.add(helper.getRandomNumberInRange(1, 100));
            i++;
        } while(i < numberOfCryptocurrencies);

        for (int id : randomIDs) {
            Cryptocurrency cryptocurrency = new Cryptocurrency(id, helper.getCryptocurrencyName(id), helper.getCryptocurrencyMarketCap(id), helper.getCryptocurrencyPrice(id), helper.getCryptocurrencyVolume24h(id));
            listOfCryptocurrencies.add(cryptocurrency);
            homePage.addCryptocurrencyToWatchlist(id);
        }
    }

    @And("opens the watchlist in new browser tab")
    public void opensTheWatchlistInNewBrowserTab()throws InterruptedException{
        tableMenu.openMenuWatchlistInNewTab();
    }

    @Then("selected cryptocurrencies are displayed in the watchlist tab")
    public void selectedCryptocurrenciesAreDisplayedInTheWatchlistTab() {
        boolean listMatches = helper.verifyListOfDisplayedCryptocurrencies(listOfCryptocurrencies);
        Assert.assertEquals("", true, listMatches);
    }

    @When("user selects full list option for cryptocurrencies {}")
    public void userSelectsFullListOptionForCryptocurrenciesGroup(String group) {
        tableMenu.openMenuCryptocurrencies();
        if (group.equals("All Cryptocurrencies")) {
            tableMenu.showAllCryptocurrenciesFullList();
        }
        if (group.equals("Coins Only")) {
            tableMenu.showCoinsOnlyFullList();
        }
        if (group.equals("Tokens Only")) {
            tableMenu.showTokensOnlyFullList();
        }
        // todo add listed cryptocurrencies into list
    }

    @And("user applies filters with {}, {} and {}")
    public void userAppliesFiltersWithMarketCapPriceAndVolume(String marketCap, String price, String volume) {
        filter.filterMarketCap(marketCap);
        filter.filterPrice(price);
        filter.filterVolume24h(volume);
    }

    @Then("cryptocurrencies that match the filters are displayed")
    public void cryptocurrenciesThatMatchTheFiltersAreDisplayed() {
        //todo compare full list of cryptocurrencies with filtered list
        boolean listMatches = helper.verifyListOfDisplayedCryptocurrenciesWithFilter(listOfCryptocurrencies);
        Assert.assertEquals("", true, listMatches);
    }
}
