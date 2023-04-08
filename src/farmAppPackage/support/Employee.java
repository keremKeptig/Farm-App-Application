package farmAppPackage.support;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Abstract Class has attributes that integer, string, calendar and also implements Payment and Comparable interfaces.
 * @author Kerem Keptig 2453355.
 * @version JDK 19
 */
public abstract class Employee implements Payment,Comparable, Serializable {
    private int empID;
    private String gender;
    private Calendar dateOfBirth;

    /**
     *  Default constructor makes all values initially zero or null.
     */
    public Employee() {
        this.empID = 0;
        this.gender = "Unknown";
        this.dateOfBirth = Calendar.getInstance();
        this.dateOfBirth.set(00,00,0000);
    }

    /**
     * The constructor, which takes all the parameters,and assigns it to the values in the class.
     * @param empID employee id of employee.
     * @param gender gender of employee.
     * @param dateOfBirth employee date of birth.
     */
    public Employee(int empID, String gender, Calendar dateOfBirth) {
        this.empID = empID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * interface method, common method for veterinary and farmWorker.
     * Just a declaration.
     * @return -1 means null.
     */
    public double getSalary() {
        return -1.0;
    }

    /**
     * interface method, common method for veterinary and farmWorker.
     * Just a declaration.
     * @param o the object to be compared.
     * @return 0 means null.
     */
    public int compareTo(Object o) {
        return 0;
    }

    /**
     * Gets employee id of employee.
     * @return employee id of employee.
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * Sets employee id of employee.
     * @param empID employee id the new employee id of employee.
     */
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    /**
     * Gets gender of employee.
     * @return gender of employee.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender of employee.
     * @param gender gender the new gender of employee.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets birthdate of employee.
     * @return birthdate of employee.
     */
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets birthdate of employee.
     * @param dateOfBirth birthdate of employee.
     */
    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
