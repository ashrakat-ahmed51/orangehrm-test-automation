package Base;

import PageSections.*;
import Pages.Admin.*;
import Pages.*;
import Pages.PIM.*;
import Pages.Time.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class BasePage {
    protected WebDriver driver;
    protected String url;
    protected WebDriverWait wait;
    HeaderSection headerSection;
    SidePanel sidePanel;

    public BasePage(WebDriver driver){
        this.driver = driver;
        sidePanel = new SidePanel();
        headerSection = new HeaderSection();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isPageDisplayed(){
        return url.equals(driver.getCurrentUrl());
    }

    public AdminPage goToAdminPage(){
        sleep(1);
        click(sidePanel.getAdminButton());
        return new AdminPage(driver);
    }

    public PIMPage goToPIMPage(){
        click(sidePanel.getPimButton());
        return new PIMPage(driver);
    }

    public DashboardPage goToDashboardPage(){
        click(sidePanel.getDashboardButton());
        return new DashboardPage(driver);
    }

    public TimePage goToTimePage(){
        click(sidePanel.getTimeButton());
        return new TimePage(driver);
    }

    public EmployeeProfilePage goToMyInfoPage(){
        click(sidePanel.getMyInfoButton());
        return new EmployeeProfilePage(driver);
    }

    public String getPageName(){
        return getText(headerSection.getPageName());
    }

    public LoginPage logout(){
        click(headerSection.getProfileButton());
        click(headerSection.getLogoutButton());
        return new LoginPage(driver);
    }

    public void scrollDownTo(WebElement e){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
    }

    public void type(By locator, String text){
        WebElement element = getElement(locator);
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        assert element != null;
        String tag = element.getTagName();
        if(tag.equalsIgnoreCase("input") || tag.equalsIgnoreCase("textarea")) {
            return Objects.requireNonNull(element.getAttribute("value")).trim();
        } else {
            return element.getText().trim();
        }
    }

    public WebElement getElement(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitToPageToLoad(String pageUrl){
        wait.until(ExpectedConditions.urlContains(pageUrl));
    }

    public void chooseFromDropDown(By dropDown, String desired){
        click(dropDown);
        By optionLocator = By.xpath("//div[@role='listbox']/div[@role='option']/span");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        List<WebElement> options = driver.findElements(optionLocator);
        for(WebElement option: options){
            if(option.getText().equals(desired)){
                option.click();
                return;
            }
        }
    }
    public boolean equalsText(By locator, String expected) {
        return expected.equals(getText(locator));
    }

    public void waitForLoadingToFinish() {
        By loader = By.cssSelector(".oxd-loading-spinner");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    protected void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
