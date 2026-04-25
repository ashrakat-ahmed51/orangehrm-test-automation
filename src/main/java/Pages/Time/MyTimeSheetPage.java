package Pages.Time;

import Pages.PIM.ReportsListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTimeSheetPage extends TimePage {
    private final By editButton;
    private final By submitButton;
    private final By projectNameField;

    private final By searchButton;
    private final By resetButton;


    public MyTimeSheetPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/time/viewMyTimesheet";

        editButton = By.cssSelector("button[type='button'][class='oxd-button oxd-button--medium oxd-button--ghost']");
        submitButton = By.cssSelector("button[type='button'][class='oxd-button oxd-button--medium oxd-button--secondary']");
        projectNameField = By.cssSelector("input[placeholder='Type for hints...']");
        searchButton = By.cssSelector("button[type='submit']");
        resetButton = By.cssSelector("button[type='button'][class='oxd-button oxd-button--medium oxd-button--ghost']");
    }
}
