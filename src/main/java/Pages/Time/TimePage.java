package Pages.Time;

import Base.BasePage;
import org.openqa.selenium.*;

public class TimePage extends BasePage {
    private final By timesheetButton;
    private final By myTimesheetsButton;
    private final By employeeTimesheetsButton;

    public TimePage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet";
        timesheetButton = By.xpath("//span[text()='Timesheets ']");
        myTimesheetsButton = By.xpath("//a[text()='My Timesheets']");
        employeeTimesheetsButton = By.xpath("//a[text()='Employee Timesheets']");
    }

    public EmployeeTimesheetsPage goToEmployeeTimesheetsPage(){
        click(timesheetButton);
        click(employeeTimesheetsButton);
        return new EmployeeTimesheetsPage(driver);
    }

    public MyTimeSheetPage goToMyTimesheetsPage(){
        click(timesheetButton);
        click(myTimesheetsButton);
        return new MyTimeSheetPage(driver);

    }
}
