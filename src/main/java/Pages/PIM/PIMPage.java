package Pages.PIM;

import DataClasses.EmployeeData;
import Base.BasePage;
import org.openqa.selenium.*;

public class PIMPage extends BasePage {

    private final By addEmployeeButton;
    private final By employeeListButton;


    public PIMPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        this.addEmployeeButton = By.linkText("Add Employee");
        this.employeeListButton = By.linkText("Employee List");


    }

    public AddEmployeePage goToAddEmployeePage(){
        click(addEmployeeButton);
        return new AddEmployeePage(driver);
    }

    public EmployeeListPage goToEmployeeListPage(){
        click(employeeListButton);
        return new EmployeeListPage(driver);
    }

//    public void AddEmployee(EmployeeData data){
//        getElement(addEmployeeButton).click();
//        getElement(firstNameField).sendKeys(data.firstName);
//        getElement(middleNameField).sendKeys(data.middleName);
//        getElement(lastNameField).sendKeys(data.lastName);
//        if(!data.employeeID.isEmpty()){
//            getElement(employeeIDField).clear();
//            getElement(employeeIDField).sendKeys(data.employeeID);
//        }
//        if(data.loginDetails){
//            getElement(createLoginDetailsField).click();
//            getElement(userNameField).sendKeys(data.username);
//            if(!data.status)
//                getElement(statusField).click();
//            getElement(passwordField).sendKeys(data.password);
//            getElement(confirmPasswordField).sendKeys(data.confirmPassword);
//        }
//        getElement(this.saveButton).click();
//    }
}
