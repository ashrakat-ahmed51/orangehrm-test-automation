package PageSections;

import org.openqa.selenium.*;

public class SidePanel {
    private final By adminButton;
    private final By pimButton;
    private final By timeButton;
    private final By dashboardButton;
    private final By myInfoButton;

    public SidePanel(){
        this.adminButton = By.linkText("Admin");
        this.pimButton = By.linkText("PIM");
        this.timeButton = By.linkText("Time");
        this.dashboardButton = By.linkText("Dashboard");
        this.myInfoButton = By.linkText("My Info");
    }

    public By getAdminButton() {
        return adminButton;
    }

    public By getPimButton() {
        return pimButton;
    }

    public By getTimeButton() {
        return timeButton;
    }

    public By getDashboardButton() {
        return dashboardButton;
    }

    public By getMyInfoButton(){return myInfoButton;}
}
