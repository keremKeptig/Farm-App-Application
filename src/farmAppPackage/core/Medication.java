package farmAppPackage.core;

import java.io.Serializable;
import java.util.Calendar;

/**
 *  Class has attributes that string, integer, calendar, double and string attributes.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public class Medication implements Serializable {
    private String details;
    private int duration;
    private Calendar startDate;
    private double dosage;
    private String notes;

    /**
     * Default constructor makes all values initially zero or null.
     */
    public Medication() {
        this.details = "Unknown";
        this.duration = 0;
        this.startDate = Calendar.getInstance();
        this.startDate .set(00,00,0000);
        this.dosage = 0.0;
        this.notes = "Unknown";
    }

    /**
     * The constructor, which takes all the parameters,and assigns it to the values in the class.
     * @param details the details of the animal medication.
     * @param duration the duration of the animal medication.
     * @param startDate the start date of the animal medication.
     * @param dosage the dosage of the animal medication.
     * @param notes the notes of the animal medication.
     */
    public Medication(String details, int duration, Calendar startDate, double dosage, String notes) {
        this.details = details;
        this.duration = duration;
        this.startDate = Calendar.getInstance();
        this.startDate.set(startDate.get(Calendar.YEAR),startDate.get(Calendar.MONTH),startDate.get(Calendar.DATE));
        this.dosage = dosage;
        this.notes = notes;
    }

    /**
     * Gets animal's medication details.
     * @return animal's medication details.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets animal's medication details.
     * @param details the new details of the animal medication.
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Gets animal's medication duration.
     * @return animal's duration details.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets animal's medication duration.
     * @param duration the new duration of the animal medication.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets animal's medication start date.
     * @return animal's start date.
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * Sets animal's start date.
     * @param startDate the new start date of the animal medication.
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets animal's medication dosage.
     * @return animal's dosage.
     */
    public double getDosage() {
        return dosage;
    }

    /**
     * Sets animal's dosage.
     * @param dosage the new dosage of the animal medication.
     */
    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    /**
     * Gets animal's notes
     * @return animal's notes.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets animal's notes.
     * @param notes the new notes of the animal medication.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
