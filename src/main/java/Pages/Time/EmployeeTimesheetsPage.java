package Pages.Time;

import Base.BasePage;
import Pages.PIM.EmployeeListPage;
import org.openqa.selenium.WebDriver;

public class EmployeeTimesheetsPage extends TimePage {

    public EmployeeTimesheetsPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet";
    }
}
