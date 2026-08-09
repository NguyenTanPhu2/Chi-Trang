package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class airbnbHomePage {

    public static void main(String[] args) {
        // 1. Khởi tạo Driver và wait
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Mở trang web
            driver.get("https://demo5.cybersoft.edu.vn/");
            System.out.println("===> Đã mở trang web thành công!");

            // 1 Locate & Click Logo
            ///Them WebElement de lay text
            By byLnkLogoCyberSoft = By.xpath("//span[text()='CyberSoft']");
            WebElement lnkLogoCyberSoft = wait.until(ExpectedConditions.elementToBeClickable(byLnkLogoCyberSoft));
            lnkLogoCyberSoft.click();
            String logo = lnkLogoCyberSoft.getText();
            System.out.println("===> Logo: " + logo);

            // 2 Click Home
            ///them webelement
            By byLnkHome = By.xpath("//a[text()='Home']");
            WebElement lnkHome = wait.until(ExpectedConditions.elementToBeClickable(byLnkHome));
            lnkHome.click();
            String home = lnkHome.getText();
            System.out.println("===> Tag: " + home);

            // 3 Click ABOUT
            ///Them webelement
            By byLnkAbout = By.xpath("//a[text()='About']");
            WebElement lnkAbout = wait.until(ExpectedConditions.elementToBeClickable(byLnkAbout));
            lnkAbout.click();
            String about = lnkAbout.getText();
            System.out.println("===> Tag: " + about);

            // 4. Click User Icon
            By byBtnUserIcon = By.xpath("//button[img[contains(@src, 'flaticon.com')]]");
//            By byLnkLogin = By.xpath("//a[contains(text(), 'Đăng nhập')]");
//            By byLnkRegister = By.xpath("//a[contains(text(), 'Đăng ký')]");
            WebElement btnUserIcon = wait.until(ExpectedConditions.elementToBeClickable(byBtnUserIcon));
            btnUserIcon.click();
//            wait.until(ExpectedConditions.elementToBeClickable(byLnkLogin)).click();
            Thread.sleep(2000);
            // 5. Địa điểm
            btnUserIcon.click();
///Thay doi xpath
            rollDownPage(driver);
            By byBtnSelectLocation = By.xpath("//div[./p[text()='Địa điểm']]");
            wait.until(ExpectedConditions.elementToBeClickable(byBtnSelectLocation)).click();
            Thread.sleep(2000);

            // 6. time
            ///Thay doi xpath
            By byBtnDatePicker = By.xpath("//div[contains(@class,'col-span-4')]");
//            By bySecCalendarPopup = By.xpath("//div[contains(@class, 'rdrDateRangePickerWrapper')]");
            wait.until(ExpectedConditions.elementToBeClickable(byBtnDatePicker)).click();
//            boolean isCalendarDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(bySecCalendarPopup)).isDisplayed();
            Thread.sleep(2000);

            // 7.8.9 ADD KHÁCH, +, -
            ///Doi xpath
            By byBtnAddGuest = By.xpath("//div[p[text()='Thêm khách']]");
            By byBtnIncreaseGuest = By.xpath("//button[.='+']");
            By byBtnDecreaseGuest = By.xpath("//button[.='-']");
            wait.until(ExpectedConditions.elementToBeClickable(byBtnAddGuest)).click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(byBtnIncreaseGuest)).click();
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(byBtnDecreaseGuest)).click();
            Thread.sleep(2000);

            // 10. Click HCM
            By byCrdHoChiMinh = By.xpath("//a[contains(@href, 'ho-chi-minh')]");
            wait.until(ExpectedConditions.elementToBeClickable(byCrdHoChiMinh)).click();

            // 11. Cần Thơ
            ///Goi de tra ve home page

            By byClickhome = By.xpath("//a[text()='Home']");
            WebElement cllickhome = wait.until(ExpectedConditions.elementToBeClickable(byClickhome));
            cllickhome.click();
            rollDownPage(driver);
///DOI XPATH CHI IN WEB KHONG THAO TAC DUOC
//            By byCrdCanTho = By.xpath("//a[contains(., 'Cần Thơ')]");
            By byLblCanThoTitle = By.xpath("//h2[text()='Cần Thơ']");
           WebElement lblCanThoTitle =  wait.until(ExpectedConditions.elementToBeClickable(byLblCanThoTitle));
            String titleCanTho= lblCanThoTitle.getText();
            System.out.println("===> City: " + titleCanTho);

            // 12. Loại nơi ở
            ///iN RA TEXT DO WEB KHONG THAO TAC
            By byBtnFilterPlaceType = By.xpath("//button[text()='Loại nơi ở']");
          WebElement btnFilterPlaceType=  wait.until(ExpectedConditions.elementToBeClickable(byBtnFilterPlaceType));
          String place = btnFilterPlaceType.getText();
            System.out.println("===> " + place);

            // 13. Giá
            ///iN RA TEXT DO WEB KHONG THAO TAC
            By byBtnFilterPrice = By.xpath("//button[text()='Giá']");
           WebElement btnFilterPrice = wait.until(ExpectedConditions.elementToBeClickable(byBtnFilterPrice));
           String price = btnFilterPrice.getText();
            System.out.println("===> " + price);

            // 14. Giờ Lái xe
            By byLblNhaTrangDriveTime = By.xpath("//h2[text()='Nha Trang']/following-sibling::p");
            WebElement lblNhaTrangDriveTime = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblNhaTrangDriveTime));
            String actualDriveTime = lblNhaTrangDriveTime.getText();
            System.out.println("===> " + actualDriveTime);

        } catch (Exception e) {
            System.out.println("===> FAIL Bài test thất bại do lỗi: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    /// Dung de roll xuong trang web de xem UI
    public static void rollDownPage(WebDriver driver) {
        //Trang roll xuong 500px
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 450).perform();

    }
}