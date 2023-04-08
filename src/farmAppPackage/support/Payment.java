package farmAppPackage.support;

import java.io.Serializable;

/**
 *  Interface has static double value which is 10000 and only one public double method.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public interface Payment {
    double grossSalary = 10000;

    /**
     * Just a declaration of getSalary.
     * @return
     */
    double getSalary();
}
