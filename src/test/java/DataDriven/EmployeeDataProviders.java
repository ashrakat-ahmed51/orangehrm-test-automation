package DataDriven;

import DataClasses.EmployeeData;
import org.testng.annotations.DataProvider;

public class EmployeeDataProviders {
    @DataProvider(name = "validEmployeeDataProvider")
    public Object[][] validEmployeeDataProvider(){
        return new Object[][]{
                {new EmployeeData("Test", "Test", "Test", "1234", true,
                        "Test1", true, "Test123456789", "Test123456789")},
                //{new EmployeeData("Test", "", "Test", "1234", false)},
        };
    }
}
