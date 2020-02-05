package test.coinmarketcap.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WatchlistPage {
    WebDriver watchlist;
    String watchlistURL = "https://coinmarketcap.com/watchlist/";
    public WatchlistPage(WebDriver driver) {
        this.watchlist = driver;
    }

   // By urlLink =

    public void open() throws InterruptedException
    {
        //watchlist.get(watchlistURL);
        //watchlist.switchTo().window()
        ((JavascriptExecutor) watchlist).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(watchlist.getWindowHandles());
        watchlist.switchTo().window(tabs.get(1));
        watchlist.get(watchlistURL);
        Thread.sleep(3000);

    }
}
