package Tests;

import Pages.DashboardPage;
import Pages.PIM.PIMPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void something(){
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        assertTrue(dashboardPage.isPageDisplayed(), "Error: The Dashboard is not displayed!!");
        assertEquals(dashboardPage.getPageName(), "Dashboard", "Error the Dashboard page name is incorrect");
        PIMPage pimPage = dashboardPage.goToPIMPage();
        assertTrue(pimPage.isPageDisplayed(), "Error: The PIM Page is not dispalyed");
        assertEquals(pimPage.getPageName(), "PIM", "Error: THe PIM Page name is incorrect");
    }
}
