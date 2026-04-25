package Tests;

import Pages.Admin.*;
import Pages.DashboardPage;
import Pages.PIM.*;
import org.testng.annotations.*;

import java.util.Random;

public class EmployeeCreationAndRoleAssignmentTest extends BaseTest{
    Random rand = new Random();
    String username = "LOOL" + rand.nextInt(100);

    @Test
    public void createEmployeeAndAssignRole(){

        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        assertTrue(dashboardPage.isPageDisplayed(), "Error: The page is not displayed!");
        assertEquals(dashboardPage.getPageName(), "Dashboard", "Error: The Page name is not the same");

        PIMPage pimPage = dashboardPage.goToPIMPage();
        assertTrue(pimPage.isPageDisplayed(), "Error: The page is not displayed!!");
        assertEquals(pimPage.getPageName(), "PIM", "Error: The Page name is not the same");

        AddEmployeePage addEmployeePage = pimPage.goToAddEmployeePage();
        assertTrue(addEmployeePage.isPageDisplayed(), "Error: The page is not displayed!!");

        addEmployeePage.addPersonalInfo("Test", "", "Test", "0411", true);
        EmployeeProfilePage employeeProfilePage = addEmployeePage.
                addLoginDetailsInfo(this.username, "Test12345", "Test12345", true);


        UserManagementPage userManagementPage = employeeProfilePage.goToAdminPage().goTouserManagementPage();

        EditEmployeePage editEmployeePage = userManagementPage.openEmployeePage(this.username);
        userManagementPage = editEmployeePage.changeRole("ESS");

        loginPage = userManagementPage.logout();
        assertTrue(loginPage.isPageDisplayed(), "Error: The page is not displayed!!");

        dashboardPage = loginPage.login(this.username, "Test12345");

    }
}
