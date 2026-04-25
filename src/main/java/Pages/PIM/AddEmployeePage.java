package Pages.PIM;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage extends PIMPage {

    private final By firstNameField;
    private final By middleNameField;
    private final By lastNameField;
    private final By employeeIDField;
    private final By createLoginDetailsField;
    private final By userNameField;
    private final By statusField;
    private final By passwordField;
    private final By confirmPasswordField;

    private final By saveButton;
    private final By cancelButton;

    public AddEmployeePage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";

        this.firstNameField = By.name("firstName");
        this.middleNameField = By.name("middleName");
        this.lastNameField = By.name("lastName");
        this.employeeIDField = By.xpath("//label[text()='Employee Id']/following::input[1]");
        this.createLoginDetailsField = By.xpath("//div[@class='oxd-switch-wrapper']/label");
        this.userNameField = By.xpath("//label[text()='Username']/following::input[1]");
        this.statusField = By.cssSelector("//label[text()='Disabled']/preceding-sibling::input");
        this.passwordField = By.xpath("//label[text()='Password']/following::input[1]");
        this.confirmPasswordField = By.xpath("//label[text()='Confirm Password']/following::input[1]");
        this.saveButton = By.cssSelector("button[type='submit']");
        this.cancelButton = By.cssSelector("button[type='button'][class='oxd-button oxd-button--medium oxd-button--ghost']");
    }

    public void addPersonalInfo(String firstName, String middleName, String lastName, String employeeID, boolean create){
        type(firstNameField, firstName);
        type(middleNameField, middleName);
        type(lastNameField, lastName);
        type(employeeIDField, employeeID);
        if(create)
            click(createLoginDetailsField);
    }

    public EmployeeProfilePage addLoginDetailsInfo(String username, String password, String confirmPassword, boolean status){
        type(userNameField, username);
        type(passwordField, password);
        type(confirmPasswordField, confirmPassword);
        if(!status)
            click(statusField);
        click(saveButton);
        waitToPageToLoad("/pim/viewPersonalDetails/empNumber");
        return new EmployeeProfilePage(driver);
    }

}
