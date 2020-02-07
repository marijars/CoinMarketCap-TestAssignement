package test.coinmarketcap.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterCryptocurrencies {
    WebDriver filter;

    public FilterCryptocurrencies(WebDriver driver) {
        this.filter = driver;
    }

    // elements
    By filterMarketCap = By.xpath("");

    By filterPrice = By.xpath("");

    By filterVolume24h = By.xpath("");

    // actions

    public void filterMarketCap(String marketCap) {

    }

    public void filterPrice(String price) {

    }

    public void filterVolume24h(String volume24h) {

    }
}
