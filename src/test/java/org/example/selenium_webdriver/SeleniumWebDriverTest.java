package org.example.selenium_webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriverTest {

    private WebDriver webDriver;
//
//    @BeforeEach
//    void setup(){
//        WebDriverManager.chromedriver().setup();
//        webDriver = new ChromeDriver();
//    }
//
//    @Test
//    void testSteps() throws InterruptedException {
//        webDriver.get("https://vitimex.com.vn/");
//
//        webDriver.findElement(By.xpath("//*[@id=\"myPage\"]/header/div[2]/div/div[2]/div[2]/div[2]")).click();
//
//        Thread.sleep(2000);
//
//        webDriver.findElement(By.xpath("//*[@id=\"ModalLogin\"]/div/div/div/div[1]/div[3]/a[1]")).click();
//
//        webDriver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("kien2310");
//        webDriver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("3456785437");
//        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("1234f@gmail.com");
//        webDriver.findElement(By.xpath("//*[@id=\"pass-regis\"]")).sendKeys("kien2310");
//        webDriver.findElement(By.xpath("//*[@id=\"pass-confirm\"]")).sendKeys("kien2310");
//        webDriver.findElement(By.xpath("//*[@id=\"register-form\"]/div[6]")).click();
//        webDriver.quit();
//
//
//
//
//


//
//    }
}
