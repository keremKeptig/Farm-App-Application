package farmAppPackage.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *  Class is subclass of treatment that additionally string and integer value.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public class HealthTreatment extends Treatment implements Serializable {
    private boolean emergency;
    private ArrayList<Medication> medications;
    private Veterinary veterinary;

    /**
     * The constructor, which takes all the parameters,and assigns it to the values in the class.
     * @param dateOFTreatment date of treatment.
     * @param emergency emergency of health treatment.
     * @param veterinary veterinary of health treatment.
     */
    public HealthTreatment(Calendar dateOFTreatment, boolean emergency,Veterinary veterinary) {
        super(dateOFTreatment);
        this.veterinary = veterinary;
        this.emergency = emergency;
        this.medications = new ArrayList<Medication>();
    }

    /**
     * Default constructor makes all values initially zero or null.
     */
    public HealthTreatment() {
        this.medications = new ArrayList<Medication>();
    }

    /**
     * The constructor, which takes emergency ,and assigns it to the values in the class.
     * @param emergency emergency of health treatment
     */
    public HealthTreatment(boolean emergency) {
        this.emergency = emergency;
    }

    /**
     *  Gets all animal medications in a arrayList.
     * @return all animal medications.
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }
    /**
     *  Sets all animal medications within an ArrayList.
     * @param medications medications the new medications of the animal.
     */
    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }

    /**
     * Gets veterinarian of health treatment.
     * @return veterinarian of health treatment.
     */
    public Veterinary getVeterinary() {
        return veterinary;
    }

    /**
     * Sets veterinarian of health treatment.
     * @param veterinary veterinary the new veterinarian of health treatment.
     */
    public void setVeterinary(Veterinary veterinary) {
        this.veterinary = veterinary;
    }

    /**
     * Gets emergency of health treatment.
     * @return emergency of health treatment.
     */
    public boolean isEmergency() {
        return emergency;
    }

    /**
     * Sets emergency of health treatment.
     * @param emergency emergency the new emergency of health treatment.
     */
    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }


}
