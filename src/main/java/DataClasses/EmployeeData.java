package DataClasses;

public class EmployeeData {
    public String firstName;
    public String middleName;
    public String lastName;
    public String employeeID;
    public boolean loginDetails;
    public String username;
    public boolean status;
    public String password;
    public String confirmPassword;

    public EmployeeData(String firstName, String middleName, String lastName, String employeeID, boolean loginDetails){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.loginDetails = loginDetails;
    }

    public EmployeeData(String firstName, String middleName, String lastName, String employeeID, boolean loginDetails,
                        String username, boolean status, String password, String confirmPassword){
        this(firstName, middleName, lastName, employeeID, loginDetails);
        this.username = username;
        this.status = status;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
