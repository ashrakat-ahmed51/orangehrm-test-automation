package Pages.PIM;

import Pages.PIM.Report.ReportPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReportsListPage extends PIMPage {

    private final By reportNameField;
    private final By searchButton;

    public ReportsListPage(WebDriver driver){
        super(driver);
        this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewDefinedPredefinedReports";
        reportNameField = By.cssSelector("input[placeholder='Type for hints...']");
        searchButton = By.cssSelector("button[type='submit']");
    }

    public ReportsListPage openReportPage(String name){
        type(reportNameField, name);
        click(searchButton);
        List<WebElement> searchedElements = driver.findElements(By.className("card-center"));
        for(WebElement element: searchedElements)
            if(element.findElement(By.cssSelector("div[class='data']")).getText().equals(name)){
                element.findElement(By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[3]")).click();
                return new ReportsListPage(driver);
            }
        return null;

    }
}
