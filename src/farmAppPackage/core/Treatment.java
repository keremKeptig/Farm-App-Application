package farmAppPackage.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class has attributes that calendar.
 * @author Kerem Keptig 2453355.
 * @version JDK 19
 */
public class Treatment implements Serializable {
    private Calendar dateOFTreatment;

    /**
     * The constructor, which takes date of treatment,and assigns it to the values in the class.
     * @param dateOFTreatment date of treatment.
     */
    public Treatment(Calendar dateOFTreatment) {
        this.dateOFTreatment = dateOFTreatment;
    }

    /**
     * Default constructor makes all values initially zero or null.
     */
    public Treatment() {
        this.dateOFTreatment = Calendar.getInstance();
        this.dateOFTreatment.set(00,00,0000);
    }

    /**
     * Gets date of treatment.
     * @return date of treatment.
     */
    public Calendar getDateOFTreatment() {
        return dateOFTreatment;
    }

    /**
     * Sets date of treatment.
     * @param dateOFTreatment new date of treatment.
     */
    public void setDateOFTreatment(Calendar dateOFTreatment) {
        this.dateOFTreatment = dateOFTreatment;
    }


}
