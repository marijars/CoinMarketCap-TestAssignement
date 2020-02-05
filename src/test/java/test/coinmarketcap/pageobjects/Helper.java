package test.coinmarketcap.pageobjects;

import org.openqa.selenium.WebDriver;

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



    }



