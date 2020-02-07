package test.coinmarketcap.pageobjects;

import org.openqa.selenium.WebDriver;
import test.coinmarketcap.data.Cryptocurrency;

import java.util.List;
import java.util.Random;

public class Helper {
    WebDriver helper;

    public Helper(WebDriver driver) {
        this.helper = driver;
    }

    // generate random int between min and max
    public int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public void addCryptoCurrencyToList(int id) {

    }

    public String getCryptocurrencyName(int id) {
        String name = "";
        // name = findElement( name of cryptocurrency by id );
        return name;
    }

    public int getCryptocurrencyMarketCap(int id) {
        int marketCap = 0;
        // marketCap = findElement( marketCap value of cryptocurrency by id );
        return marketCap;
    }

    public int getCryptocurrencyPrice(int id) {
        int price = 0;
        // price = findElement( price of cryptocurrency by id );
        return price;
    }

    public int getCryptocurrencyVolume24h(int id) {
        int volume24h = 0;
        // volume24h = findElement ( volume24h of crypeocurrency by id );
        return volume24h;
    }

    public boolean verifyListOfDisplayedCryptocurrencies(List<Cryptocurrency> listOfCryptocurrencies) {
        boolean result = false;
        // todo go verify that cryptocurrencies in given list are displayed in page
        return result;
    }

    public boolean verifyListOfDisplayedCryptocurrenciesWithFilter(List<Cryptocurrency> listOfCryptocurrencies) {
        boolean result = false;
        // todo go verify that filtered out cryptocurrencies are matching those in given full list
        return result;
    }
}



