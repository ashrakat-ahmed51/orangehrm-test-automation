package Tests;

import Pages.Admin.EditEmployeePage;
import Pages.DashboardPage;
import Pages.PIM.EmployeeInfo.ContactDetailsPage;
import Pages.PIM.EmployeeInfo.EmergencyContactsPage;
import Pages.PIM.EmployeeInfo.PersonalDetailsPage;
import Pages.PIM.EmployeeListPage;
import Pages.PIM.EmployeeProfilePage;
import org.testng.annotations.Test;

public class EmployeePersonalInfoUpdateTest extends BaseTest{
    @Test
    public void updatePersonalInfo(){
        DashboardPage dashboardPage = loginPage.login("LOOL49", "Test12345");
        assertTrue(dashboardPage.isPageDisplayed(), "Error");

        PersonalDetailsPage personalDetailsPage = dashboardPage.goToMyInfoPage().OpenPersonalDetailsPage();
        personalDetailsPage.changeNationality("Egyptian");
        personalDetailsPage.changeMartialStatus("Married");
        personalDetailsPage.saveChanges();

        ContactDetailsPage contactDetailsPage = personalDetailsPage.openContactDetailsPage();
        contactDetailsPage.changeContactDetails("Test", "Test", "Test", "Test", "Test", "Egypt");


        EmergencyContactsPage emergencyContactsPage = contactDetailsPage.openEmergencyContacts();
        emergencyContactsPage.addEmergencyContact("Test", "Test", "0", "", "");



        loginPage = contactDetailsPage.logout();

        dashboardPage = loginPage.login("Admin", "admin123");
        EmployeeListPage employeeListPage = dashboardPage.goToPIMPage().goToEmployeeListPage();

            EmployeeProfilePage employeeProfilePage = employeeListPage.openEmployeePage("0411");
        personalDetailsPage = employeeProfilePage.OpenPersonalDetailsPage();

        assertTrue(personalDetailsPage.checkPersonalDetails("Egyptian", "Married"), "Error");
        contactDetailsPage = personalDetailsPage.openContactDetailsPage();
        assertTrue(contactDetailsPage.checkContactDetails("Test", "Test", "Test", "Test", "Test", "Egypt"), "Error");

        emergencyContactsPage = contactDetailsPage.openEmergencyContacts();
        assertTrue(emergencyContactsPage.checkEmergencyContactDetails("Test", "Test", "0", "", ""), "Error");

    }
}
