package Pages.PIM.EmployeeInfo;

import Base.BasePage;
import Pages.Admin.UserManagementPage;
import Pages.PIM.EmployeeProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PersonalDetailsPage extends EmployeeProfilePage {
    private final By nationalityButton;
    private final By martialStatusButton;
    private final By saveButton;


    public PersonalDetailsPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/";
        nationalityButton = By.xpath("//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]");
        martialStatusButton = By.xpath("//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]");
        saveButton = By.cssSelector("button[type='submit']");
    }

    public void changeNationality(String nationality){
        chooseFromDropDown(nationalityButton, nationality);
    }

    public void changeMartialStatus(String status){
        chooseFromDropDown(martialStatusButton, status);
    }

    public void saveChanges(){click(saveButton);}

    public boolean checkPersonalDetails(String nationality, String status) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                nationalityButton, nationality
        ));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                martialStatusButton, status
        ));
        String nationalityText = driver.findElement(nationalityButton).getText().trim();

        String maritalStatusText = driver.findElement(martialStatusButton).getText().trim();

        return nationalityText.equalsIgnoreCase(nationality)
                && maritalStatusText.equalsIgnoreCase(status);
    }

}
