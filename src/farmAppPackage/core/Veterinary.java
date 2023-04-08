package farmAppPackage.core;

import farmAppPackage.support.Employee;

import java.io.Serializable;
import java.util.Calendar;

/**
 *  Class is subclass of employee that additionally boolean, integer and calendar.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public class Veterinary extends Employee implements Serializable {
    private boolean BScDegree;
    private int expertiseLevel;
    private Calendar dateOfGraduation;

    /**
     * The constructor, which takes BScDegree, expertiseLevel and dateOfGraduation,and assigns it to the values in the class.
     * @param BScDegree BScDegree of veterinary.
     * @param expertiseLevel expertiseLevel of veterinary.
     * @param dateOfGraduation dateOfGraduation of veterinary.
     */
    public Veterinary(boolean BScDegree, int expertiseLevel, Calendar dateOfGraduation) {
        this.BScDegree = BScDegree;
        this.expertiseLevel = expertiseLevel;
        this.dateOfGraduation = dateOfGraduation;
    }


    /**
     * Default constructor makes all values initially zero or null.
     */
    public Veterinary() {
        this.expertiseLevel = -1;
    }

    /**
     * The constructor, which takes all the parameters,and assigns it to the values in the class.
     * @param empID employee id of veterinary.
     * @param gender gender of veterinary.
     * @param dateOfBirth dateOfBirth of veterinary.
     * @param BScDegree BScDegree of veterinary.
     * @param expertiseLevel expertiseLevel of veterinary.
     * @param dateOfGraduation dateOfGraduation of veterinary.
     */
    public Veterinary(int empID, String gender, Calendar dateOfBirth, boolean BScDegree, int expertiseLevel, Calendar dateOfGraduation) {
        super(empID, gender, dateOfBirth);
        this.BScDegree = BScDegree;
        this.expertiseLevel = expertiseLevel;
        this.dateOfGraduation = dateOfGraduation;
    }



    /**
     * Performs employee salary.
     * @return calculated salary of employee.
     */
    public double getSalary()
    {
        Calendar calendar = Calendar.getInstance();
        int current = calendar.get(Calendar.YEAR);
        int graduateDate = this.dateOfGraduation.get(Calendar.YEAR);
        graduateDate = current - graduateDate;

        return grossSalary + (grossSalary*0.10*graduateDate);
    }

    /**
     * Performs employee salary comparison.
     * @param object the object to be compared,which is employee..
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
     * Gets BScDegree of veterinary.
     * @return BScDegree of veterinary.
     */
    public boolean isBScDegree() {
        return BScDegree;
    }

    /**
     * Sets BScDegree of veterinary.
     * @param BScDegree new BScDegree of veterinary.
     */
    public void setBScDegree(boolean BScDegree) {
        this.BScDegree = BScDegree;
    }

    /**
     * Gets expertiseLevel of veterinary.
     * @return expertiseLevel of veterinary.
     */
    public int getExpertiseLevel() {
        return expertiseLevel;
    }

    /**
     * Sets expertiseLevel of veterinary.
     * @param expertiseLevel new expertiseLevel of veterinary.
     */
    public void setExpertiseLevel(int expertiseLevel) {
        this.expertiseLevel = expertiseLevel;
    }

    /**
     * Gets dateOfGraduation of veterinary.
     * @return dateOfGraduation of veterinary.
     */
    public Calendar getDateOfGraduation() {
        return dateOfGraduation;
    }

    /**
     * Sets dateOfGraduation of veterinary.
     * @param dateOfGraduation new dateOfGraduation of veterinary.
     */
    public void setDateOfGraduation(Calendar dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }
}
