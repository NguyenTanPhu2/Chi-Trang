package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class hrmAdminPage {
    public static void main(String[] args) {
        // Khởi tạo Driver và Wait
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            // BƯỚC KHỞI TẠO: MỞ TRANG WEB & ĐĂNG NHẬP
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

            // 1 - Menu Admin
            By byMnuAdmin = By.xpath("//span[text()='Admin']");
            WebElement mnuAdmin = wait.until(ExpectedConditions.elementToBeClickable(byMnuAdmin));
            mnuAdmin.click();


            // 2 - Menu PIM:
            By byMnuPIM = By.xpath("//span[text()='PIM']");
            WebElement mnuPIM = wait.until(ExpectedConditions.elementToBeClickable(byMnuPIM));
            mnuPIM.click();


            // 3 - Menu Leave
            By byMnuLeave = By.xpath("//span[text()='Leave']");
            WebElement mnuLeave = wait.until(ExpectedConditions.elementToBeClickable(byMnuLeave));
            mnuLeave.click();

            // Quay lại Admin để tiếp tục thao tác form
            wait.until(ExpectedConditions.elementToBeClickable(byMnuAdmin)).click();

            // 4 - Ô nhập Username
            By byTxtUsername = By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input");
            WebElement txtUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtUsername));
            txtUsername.sendKeys("Anthony.Nolan");
            Thread.sleep(3000);

            // 5 - Dropdown User Role (Nút chọn role)
            By byDdlUserRole = By.xpath("//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']");
            By byOptAdmin = By.xpath("//div[@role='option']//span[text()='Admin']");
            By byOptESS = By.xpath("//div[@role='option']//span[text()='ESS']");

          // Lần 1: Click mở Dropdown -> Chờ Option Admin HIỂN THỊ hẳn rồi mới Click
            wait.until(ExpectedConditions.elementToBeClickable(byDdlUserRole)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(byOptAdmin)).click();

          // Lần 2: Click mở lại Dropdown -> Chờ Option ESS HIỂN THỊ hẳn rồi mới Click
            wait.until(ExpectedConditions.elementToBeClickable(byDdlUserRole)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(byOptESS)).click();

            // 8 - Ô nhập/Gợi ý Employee Name

            /// Them code cho de select data
            By byTxtEmployeeName = By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input");
            WebElement txtEmployeeName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmployeeName));
            txtEmployeeName.sendKeys("A");
            String EmployeeName = txtEmployeeName.getText();
            Thread.sleep(3000);

            // Chờ đúng tên xuất hiện trong danh sách
            By byOption = By.xpath("//div[@role='option']//span[contains(.,'" + EmployeeName + "')]");
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(byOption));
            option.click();
            Thread.sleep(3000);

            // 9 - Nút Reset:
            By byBtnReset = By.xpath("//button[normalize-space()='Reset']");
            WebElement btnReset = wait.until(ExpectedConditions.elementToBeClickable(byBtnReset));
            btnReset.click();
            Thread.sleep(3000);

            // 10 - Nút Search:
            By byBtnSearch = By.xpath("//button[@type='submit']");
            WebElement btnSearch = wait.until(ExpectedConditions.elementToBeClickable(byBtnSearch));
            btnSearch.click();
            Thread.sleep(3000);

            // 11 - Dropdown User Management:
            By byDdlUserManagement = By.xpath("//span[contains(text(),'User Management')]");
            WebElement ddlUserManagement = wait.until(ExpectedConditions.elementToBeClickable(byDdlUserManagement));
            ddlUserManagement.click();
            Thread.sleep(3000);

            // 12 - Ô Checkbox chọn dòng dữ liệu thứ 2:
            By byCbxRow2 = By.xpath("(//div[@class='oxd-table-card'])[2]//input[@type='checkbox']");
            WebElement cbxRow2 = wait.until(ExpectedConditions.presenceOfElementLocated(byCbxRow2));

            if (!cbxRow2.isSelected()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cbxRow2);
            }
            Thread.sleep(3000);

            // 13 - Giá trị cột User Role ở dòng thứ 2:
            By byCellRole = By.xpath("(//div[@class='oxd-table-card'])[2]//div[@role='cell'][3]");
            WebElement cellRole = wait.until(ExpectedConditions.visibilityOfElementLocated(byCellRole));
            String actualRole = cellRole.getText();

            System.out.println("===> User Role ở dòng thứ 2: " + actualRole);


            // Kiểm tra với Assert
            /// Dong nay em chua hieu - de chi can in text data
//            if (!actualRole.equals("ESS")) {
//                System.err.println("Lỗi: Role không phải ESS! Thực tế: " + actualRole);
//            }

            // 14 - Nút Delete (Thùng rác) ở dòng thứ 2:
            By byBtnDelete = By.xpath("(//div[@class='oxd-table-card'])[2]//button[./i[contains(@class,'bi-trash')]]");
            WebElement btnDelete = wait.until(ExpectedConditions.elementToBeClickable(byBtnDelete));
            btnDelete.click();
            ///Them confirm delete de dong page confirm delete
            Thread.sleep(2000);
            By byBtnConfirmDelete = By.xpath("//button[text()=' No, Cancel ']");
            WebElement btnConfirmDelete = wait.until(ExpectedConditions.elementToBeClickable(byBtnConfirmDelete));
            btnConfirmDelete.click();

            // 15 - Nút Edit (Cây bút) ở dòng thứ 2:
            By byBtnEdit = By.xpath("(//div[@class='oxd-table-card'])[2]//button[./i[contains(@class,'bi-pencil-fill')]]");
            WebElement btnEdit = wait.until(ExpectedConditions.elementToBeClickable(byBtnEdit));
            btnEdit.click();
            Thread.sleep(2000);

            ///Them confirm edit de dong page confirm edit quay ve page admin
        By byBtnConfirmEdit = By.xpath("//button[text()=' Cancel ']");
        WebElement btnConfirmEdit = wait.until(ExpectedConditions.elementToBeClickable(byBtnConfirmEdit));
        btnConfirmEdit.click();


            // 16 - Cột tiêu đề User Role (Header):
            By byHeaderUserRole = By.xpath("//div[@class='oxd-table-header']//div[text()='User Role']");
            WebElement headerUserRole = wait.until(ExpectedConditions.visibilityOfElementLocated(byHeaderUserRole));
            String actualHeaderUserRole = headerUserRole.getText();

            // 17 - Cột tiêu đề Employee Name (Header):
            By byHeaderEmployeeName = By.xpath("//div[@class='oxd-table-header']//div[text()='Employee Name']");
            WebElement headerEmployeeName = wait.until(ExpectedConditions.visibilityOfElementLocated(byHeaderEmployeeName));
            String actualHeaderEmployeeName = headerEmployeeName.getText();
            System.out.println("===> tiêu đề Employee Name: " + actualHeaderEmployeeName);

            // 18 - Breadcrumb Admin / User Management:

            ///Thay doi xpath
        ///lay text Admin
            By byBrdAdmin = By.xpath("//h6[contains(@class,'breadcrumb-module')]");
            WebElement brdAdmin = wait.until(ExpectedConditions.visibilityOfElementLocated(byBrdAdmin));

            By byBrdUserManagement = By.xpath("//h6[contains(@class,'breadcrumb-level')]");
            WebElement brdUserManagement = wait.until(ExpectedConditions.visibilityOfElementLocated(byBrdUserManagement));

            String actualBreadcrumbbrdUserManagement = brdUserManagement.getText();
            String actualBreadcrumbbrdAdmin = brdAdmin.getText();

//            if (!actualBreadcrumb.equals("User Management")) {
//                System.err.println("Lỗi: Breadcrumb sai! Thực tế: " + actualBreadcrumb);
//            }
            ///in text Admin/User Management
            System.out.println("===> Brand: " + actualBreadcrumbbrdAdmin + "/" + actualBreadcrumbbrdUserManagement);

            // 19 - Nút Toggle Sidebar
            By byBtnToggleSidebar = By.xpath("//button[contains(@class,'oxd-main-menu-button')]");
            WebElement btnToggleSidebar = wait.until(ExpectedConditions.elementToBeClickable(byBtnToggleSidebar));
            btnToggleSidebar.click();

            // 20 - Nút Thu gọn/Mở rộng Filter Form
            By byBtnCollapseFilter = By.xpath("//button[contains(@class,'oxd-icon-button') and .//i[contains(@class,'bi-caret-up-fill')]]");
            WebElement btnCollapseFilter = wait.until(ExpectedConditions.elementToBeClickable(byBtnCollapseFilter));
            btnCollapseFilter.click();
            Thread.sleep(2000);

            // 21 - Nút + Add (Thêm người dùng mới):
            By byBtnAdd = By.xpath("//button[normalize-space()='Add']");
            WebElement btnAdd = wait.until(ExpectedConditions.elementToBeClickable(byBtnAdd));
            btnAdd.click();
            Thread.sleep(2000);


        } catch (Exception e) {
            System.err.println("Bài test thất bại do lỗi: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}