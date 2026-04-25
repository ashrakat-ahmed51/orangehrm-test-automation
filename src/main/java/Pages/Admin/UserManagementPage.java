package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserManagementPage extends AdminPage{
    private final By usernameField;
    private final By searchButton;
    private final By users;

    public UserManagementPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        this.usernameField = By.xpath("//label[text()='Username']/following::input[1]");

        this.searchButton = By.cssSelector("button[type='submit']");
        this.users = By.cssSelector("div.oxd-table-body div.oxd-table-row");
    }

    public WebElement searchByUsername(String username){
        type(usernameField, username);
        click(searchButton);

        wait.until(ExpectedConditions.presenceOfElementLocated(users));

        for (WebElement row : driver.findElements(users)) {
            if (row.getText().contains(username)) {
                return row;
            }
        }

        throw new NoSuchElementException("User not found: " + username);
    }
    public EditEmployeePage openEmployeePage(String username){
        WebElement user = searchByUsername(username);
        WebElement editButton = user.findElement(By.xpath(".//i[contains(@class,'bi-pencil-fill')]"));
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        return new EditEmployeePage(driver);
    }
}
