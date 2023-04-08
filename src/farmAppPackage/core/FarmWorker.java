package farmAppPackage.core;

import farmAppPackage.support.Employee;

import java.io.Serializable;
import java.util.Calendar;

/**
 *  Class is subclass of employee that additionally string and integer value.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public class FarmWorker extends Employee implements Serializable {
    private String previousFarmName;
    private int workexperience;

    /**
     * The constructor, which takes previousFarmName and workexperiencethe and assigns it to the values in the class.
     * @param previousFarmName revious farm name of FarmWorker.
     * @param workexperience work experience of FarmWorker.
     */
    public FarmWorker(String previousFarmName, int workexperience) {
        this.previousFarmName = previousFarmName;
        this.workexperience = workexperience;
    }

    /**
     * The constructor, which takes all the parameters,and assigns it to the values in the class.
     * @param empID employee id of FarmWorker.
     * @param gender gender of FarmWorker.
     * @param dateOfBirth FarmWorker date of birth.
     * @param previousFarmName previous farm name of FarmWorker.
     * @param workexperience work experience of FarmWorker.
     */
    public FarmWorker(int empID, String gender, Calendar dateOfBirth, String previousFarmName, int workexperience) {
        super(empID, gender, dateOfBirth);
        this.previousFarmName = previousFarmName;
        this.workexperience = workexperience;
    }

    /**
     * Default constructor makes all values initially zero or null.
     */
    public FarmWorker() {
        this.previousFarmName = "Unknown";
        this.workexperience = -1;
    }

    /**
     * Performs employee salary comparison.
     * @param object the object to be compared,which is employee.
     * @return 1 means this employee object salary is greater than other employee. 0 means the exact opposite.
     */
    public int compareTo(Object object) {
        Employee employee = (Employee) object;
        if (this.getSalary() > employee.getSalary()){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * Performs employee salary.
     * @return calculated salary of employee.
     */
    public double getSalary() {
        return grossSalary + (grossSalary*0.02*workexperience);
    }

    /**
     * Gets previous farm name of FarmWorker.
     * @return previous farm name of FarmWorker.
     */
    public String getPreviousFarmName() {
        return previousFarmName;
    }

    /**
     * Sets previous farm name of FarmWorker.
     * @param previousFarmName new previous farm name of FarmWorker.
     */
    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }

    /**
     * Gets workexperience of FarmWorker.
     * @return workexperience of FarmWorker.
     */
    public int getWorkexperience() {
        return workexperience;
    }

    /**
     * Sets workexperience of FarmWorker.
     * @param workexperience new workexperience of FarmWorker.
     */
    public void setWorkexperience(int workexperience) {
        this.workexperience = workexperience;
    }
}
