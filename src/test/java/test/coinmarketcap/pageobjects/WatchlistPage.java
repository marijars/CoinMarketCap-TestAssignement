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


}
