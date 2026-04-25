package Pages.PIM.EmployeeInfo;

import Base.BasePage;
import Pages.PIM.EmployeeProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class EmergencyContactsPage extends EmployeeProfilePage {

    private final By addButton;

    private final By nameField;
    private final By relationshipField;
    private final By homeTelephoneField;
    private final By mobileField;
    private final By workTelephoneField;

    private final By saveButton;
    private final By editButton;

    public EmergencyContactsPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmergencyContacts/empNumber/";
        addButton = By.xpath("//button[.=' Add ']");

        nameField = By.xpath("//label[text()='Name']/following::input[1]");
        relationshipField = By.xpath("//label[text()='Relationship']/following::input[1]");
        homeTelephoneField = By.xpath("//label[text()='Home Telephone']/following::input[1]");
        mobileField = By.xpath("//label[text()='Mobile']/following::input[1]");
        workTelephoneField = By.xpath("//label[text()='Work Telephone']/following::input[1]");
        editButton = By.xpath("//div[@role='row'][1]//i[contains(@class,'bi-pencil-fill')]");

        saveButton = By.cssSelector("button[type='submit']");
    }

    public void addEmergencyContact(String name, String relationship, String home, String mobile, String work){
        click(addButton);
        type(nameField, name);
        type(relationshipField, relationship);
        type(homeTelephoneField, home);
        type(mobileField, mobile);
        type(workTelephoneField, work);
        click(saveButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='orangehrm-container'])[1]")));
    }

    public boolean checkEmergencyContactDetails(String name, String relationship, String home, String mobile, String work){
        click(editButton);
        sleep(1);
        System.out.println(getText(nameField));
        System.out.println(getText(relationshipField));
        System.out.println(getText(homeTelephoneField));
        System.out.println(getText(mobileField));
        System.out.println(getText(workTelephoneField));

        boolean result =  equalsText(nameField, name) &&
                equalsText(relationshipField, relationship) &&
                equalsText(homeTelephoneField, home) &&
                equalsText(mobileField, mobile) &&
                equalsText(workTelephoneField, work);
        click(saveButton);
        return result;
    }
}
