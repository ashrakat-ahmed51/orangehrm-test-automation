package Pages;

import Base.BasePage;
import org.openqa.selenium.*;

public class LoginPage extends BasePage {
    private final By usernameField;
    private final By passwordField;
    private final By loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        this.usernameField = By.name("username");
        this.passwordField = By.name("password");
        this.loginButton = By.cssSelector("button[type='submit']");
    }

    public DashboardPage login(String username, String password){
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
        return new DashboardPage(driver);
    }
}
