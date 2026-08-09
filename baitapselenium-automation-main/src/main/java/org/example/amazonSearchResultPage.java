package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class amazonSearchResultPage {

    public static void main(String[] args) throws InterruptedException {
        // 1. Khởi tạo Driver và wait
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {

            // Mở trang web
            driver.get("https://www.amazon.com/s?k=adidas&ref=nb_sb_noss");
            System.out.println("===> Đã mở trang web thành công!");

            // 1. hình ành sản phầm
            By byImgProduct3 = By.xpath("(//img[@class='s-image'])[3]");
            wait.until(ExpectedConditions.elementToBeClickable(byImgProduct3)).click();

            // 2. Giá niêm yết
            ///Chinh xpath va doi .getText() thanh .getAttribute("textContent").trim()
            By byLblProduct2ListPrice = By.xpath("(//div[contains(@class,'a-section')]//span[contains(@class,'a-offscreen')])[2]");
            WebElement lblProduct2ListPrice = wait.until(ExpectedConditions.presenceOfElementLocated(byLblProduct2ListPrice));
            String listPriceText = lblProduct2ListPrice.getAttribute("textContent").trim();
            System.out.println("Giá niêm yết: " + listPriceText);

            // 3.Giá giảm
            By byLblProductPrice = By.xpath("(//span[contains(@class,'apex-pricetopay-value')])[1]");
            WebElement lblProductPrice = wait.until(ExpectedConditions.presenceOfElementLocated(byLblProductPrice));
            String currentPrice = lblProductPrice.getAttribute("textContent").trim();
            System.out.println("Giá giảm: " + currentPrice);

            // 4. Tìm kiếm
            //// Xem xet goi ham search() de dung lai ---> em da them chi can sua thay the thoi
            ///Co the tham khao code cua em de chinh lai de truyen vao tham so nha con ham o day em chi lam tam thoi

            By byTxtSearch = By.xpath("//input[@id='twotabsearchtextbox']");
            By byBtnSearch = By.xpath("//input[@id='nav-search-submit-button']");
            WebElement txtSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtSearch));
            txtSearch.clear();
            txtSearch.sendKeys("nike");
            WebElement btnSearch = wait.until(ExpectedConditions.elementToBeClickable(byBtnSearch));
            btnSearch.click();

            //5. Giỏ hang
            By byBtnCart = By.xpath("//a[@id='nav-cart']");
            By byLblCartCount = By.xpath("//span[@id='nav-cart-count']");
            wait.until(ExpectedConditions.elementToBeClickable(byBtnCart)).click();

            // 8. tên sản phầm
            ///Them de tro ve trang ket qua "adidas"
            searching(wait);
            ///cai nay e cho click vao te sp - co thay doi xpath
            By byLblProductTitle = By.xpath("(//h2[contains(@class,'a-text-normal')])[3]");
            WebElement lblProductTitle = wait.until(ExpectedConditions.elementToBeClickable(byLblProductTitle));
            lblProductTitle.click();


            //9. delivery
            /// thay doi xpath va dung .getAttribute("textContent").trim() thay vi .getText()
            searching(wait);
            By byLblDeliveryInfo = By.xpath("(//span[@id='WVCRIAFWG'])[2]");
            WebElement lblDeliveryInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblDeliveryInfo));
            String deliveryText = lblDeliveryInfo.getAttribute("textContent").trim();
            System.out.println("Delivery Info: " + deliveryText);

            //10. adidas brand
            By byLblBrandName = By.xpath("(//div[@data-component-type='s-search-result'])[2]//h2[contains(@class, 'a-size-mini')]//span");
            WebElement lblBrandName = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblBrandName));
            String brandText = lblBrandName.getText();
            System.out.println("Brand Name: " + brandText);

            //11. checkbox "men"
            By byChkFilterMen = By.xpath("//a[./span[text()='Men']]");
            wait.until(ExpectedConditions.elementToBeClickable(byChkFilterMen)).click();
            Thread.sleep(2000); // Thêm thời gian chờ để trang tải lại sau khi chọn checkbox

            //12. 1-48 of over 10,000 results for
            By byLblSearchResultInfo = By.xpath("//h2[contains(., 'results for')]");
            WebElement lblSearchResultInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblSearchResultInfo));
            String resultText = lblSearchResultInfo.getText();
            System.out.println("Search Result Info: " + resultText);

        } finally {
            driver.quit();
        }
    }

    public static void searching(WebDriverWait wait) {
        By bySearchBox = By.id("twotabsearchtextbox");
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(bySearchBox));
        searchBox.clear();
        searchBox.sendKeys("adidas");
        searchBox.submit();
    }
}



