package test.coinmarketcap.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TableMenuOptions {
    private WebDriver driver;
    private WatchlistPage watchlistPage;

    public TableMenuOptions(WebDriver driver) {
        this.driver = driver;
        this.watchlistPage = new WatchlistPage(driver);
    }

    // elements
    By menuCryptocurrencies = By.xpath("");

    By menyExchanges = By.xpath("");

    By menuWatchlist = By.xpath("");

    By allCryptocurrenciesTop100 = By.xpath("");

    By allCryptocurrenciesFullList = By.xpath("");

    By coinsOnlyFullList = By.xpath("");

    By tokensOnlyFullList = By.xpath("");

    // actions

    public void openMenuCryptocurrencies() {
        driver.findElement(menuCryptocurrencies).click();
    }

    public void openMenuWatchlist() {
        driver.findElement(menuWatchlist).click();
    }

    public void openMenuWatchlistInNewTab() throws InterruptedException {
        //watchlist.get(watchlistURL);
        //watchlist.switchTo().window()
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(watchlistPage.watchlistURL);
        Thread.sleep(3000);
    }

    public void showAllCryptocurrenciesFullList() {
        driver.findElement(allCryptocurrenciesFullList).click();
    }

    public void showCoinsOnlyFullList() {
        driver.findElement(coinsOnlyFullList).click();
    }

    public void showTokensOnlyFullList() {
        driver.findElement(tokensOnlyFullList).click();
    }

}
