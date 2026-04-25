package Pages.PIM;

import Base.BasePage;
import Pages.Admin.EditEmployeePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeeListPage extends PIMPage {
    private final By employeeIDField;
    private final By searchButton;
    private final By users;

    public EmployeeListPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        employeeIDField = By.xpath("//input[@class = 'oxd-input oxd-input--active' and parent::div[@class='']]");
        searchButton = By.cssSelector("button[type='submit']");
        users = By.cssSelector("div[class='oxd-table-row oxd-table-row--with-border'][role='row']");
    }

    public WebElement searchByID(String id){
        type(employeeIDField, id);
        click(searchButton);

        By userRow = By.xpath(
                "//div[@role='row' and .//div[text()='" + id + "']]"
        );

        wait.until(ExpectedConditions.presenceOfElementLocated(userRow));
        return driver.findElement(userRow);
    }

    public EmployeeProfilePage openEmployeePage(String id){
        WebElement user = searchByID(id);
        user.findElement(By.xpath(".//i[@class='oxd-icon bi-pencil-fill']")).click();
        return new EmployeeProfilePage(driver);
    }
}
