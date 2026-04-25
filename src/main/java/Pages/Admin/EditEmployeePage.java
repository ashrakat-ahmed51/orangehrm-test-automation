package Pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditEmployeePage extends UserManagementPage{

    private final By roleField;
    private final By saveButton;

    public EditEmployeePage(WebDriver driver){
        super(driver);
        roleField = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
        saveButton = By.cssSelector("button[type='submit']");
    }

    public UserManagementPage changeRole(String role){
        chooseFromDropDown(roleField, role);
        click(saveButton);
        waitToPageToLoad("/admin/viewSystemUsers");
        return new UserManagementPage(driver);
    }

}
