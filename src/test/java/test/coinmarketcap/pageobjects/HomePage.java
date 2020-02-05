package test.coinmarketcap.pageobjects;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.coinmarketcap.data.Cryptocurrency;

public class HomePage {
    WebDriver homePage;

    public HomePage(WebDriver driver) {
        this.homePage = driver;
    }

    // elements
    private String url = "https://coinmarketcap.com/";
    String pathToRowMenu = "//div[@class='cmc-table__table-wrapper-outer']//tr[%s]/td[9]/div/div/div";

    By btnViewAll = By.linkText("View All");
    By rows = By.xpath("//div[@class='cmc-table__table-wrapper-outer']//tr");
    By addToWatchlist = By.xpath("//div[@class='cmc-popover__dropdown']//ul[@role=\"menu\"]//span[contains(text(),'Add to Watchlist')]");
    By menyCryptocurrency = By.xpath("//ul[@class='cmc-tabs__header']//span[contains(text(),'Cryptocurrencies')]");
    By fullListAllCryptocurrencies = By.xpath("//a[contains(@href,'/all/views/all/')]");

    // actions
    public void clickBtnViewAll() {
        homePage.findElement(btnViewAll).click();
    }

    public void open() {
        homePage.get(url);
    }

    public int countOfCriptocurrencies() {
        int count = homePage.findElements(rows).size();
        return count-1;
    }

    public void addCryptocurrencyToWatchlist(int randomNumberInRange) throws InterruptedException {
        Thread.sleep(10000);
        WebElement rowToMenu = homePage.findElement(By.xpath(String.format(pathToRowMenu,randomNumberInRange)));
        ExpectedConditions.elementToBeClickable(rowToMenu);
        rowToMenu.click();
        //((JavascriptExecutor) homePage).executeScript("arguments[0].click();", rowToMenu);
        //((JavascriptExecutor) homePage).executeScript("arguments[0].click();", rowToMenu);
        homePage.findElement(addToWatchlist);

    }
}
