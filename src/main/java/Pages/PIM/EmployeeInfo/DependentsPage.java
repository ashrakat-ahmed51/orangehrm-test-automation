package Pages.PIM.EmployeeInfo;

import Base.BasePage;
import Pages.PIM.EmployeeProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DependentsPage extends EmployeeProfilePage {
    private final By addButton;
    private final By nameField;
    private final By relationshipField;
    private final By otherRelationshipField;
    private final By dateField;
    private final By saveButton;

    public DependentsPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewDependents/empNumber/";

        addButton = By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--text'][@type='button'])[1]");

        nameField = By.xpath("//label[text()='Name']/following::input[1]");
        relationshipField = By.xpath("//label[text()='Relationship']/following::div[contains(@class,'oxd-select-wrapper')][1]");
        otherRelationshipField = By.xpath("//label[text()='Please Specify']/following::input[1]");
        dateField = By.xpath("//label[text()='Date of Birth']/following::input[1]");
        saveButton = By.cssSelector("button[type='submit']");
    }

    public void selectRelationShip(String relationship){
        if(!relationship.equals("Child")){
            type(relationshipField, "Other");
            type(otherRelationshipField, relationship);
        }
        else
            type(relationshipField, relationship);
    }

    public void addDependency(String name, String relationship, String date){
        click(addButton);
        type(nameField, name);
        selectRelationShip(relationship);
        type(dateField, date);
        click(saveButton);
    }
}
