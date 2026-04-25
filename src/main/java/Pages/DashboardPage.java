package Pages;

import Base.BasePage;
import org.openqa.selenium.*;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    }
}
