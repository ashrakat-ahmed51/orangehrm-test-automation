package Pages.Admin;

import Base.BasePage;
import org.openqa.selenium.*;

public class AdminPage extends BasePage {

    private final By userManagementButton;
    private final By usersButton;

    public AdminPage(WebDriver driver){
        super(driver);
        userManagementButton = By.xpath("//span[text()='User Management ']");
        usersButton = By.xpath("//a[text()='Users']");
    }

    public UserManagementPage goTouserManagementPage(){
        click(userManagementButton);
        click(usersButton);
        return new UserManagementPage(driver);
    }
}

