package PageSections;

import org.openqa.selenium.*;

public class HeaderSection {
    private final By pageName;
    private final By profileButton;
    private final By logoutButton;

    public HeaderSection(){
        this.pageName = By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
        this.profileButton = By.className("oxd-userdropdown-tab");
        this.logoutButton = By.xpath("//a[text()='Logout']");
    }

    public By getPageName() {
        return pageName;
    }

    public By getProfileButton() {
        return profileButton;
    }

    public By getLogoutButton(){
        return logoutButton;
    }
}
