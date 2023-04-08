package farmAppPackage.support;

import farmAppPackage.core.Treatment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *  Abstract Class has attributes that integer, string, calendar, boolean, HashMap and treatment list.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public abstract class Animal implements Serializable {
    private int tagNo;
    private String gender;
    private Calendar dateOfBirth;
    private boolean purchased;
    private HashMap milking;

    private ArrayList<Treatment> treatment;

    /**
     *  Default constructor makes all values initially zero or null.
     */
    public Animal() {
        this.tagNo = 0;
        this.gender = "Unknown";
        dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(00,00,0000);
        this.purchased = false;
        this.treatment = new ArrayList<Treatment>();
        HashMap<String,Double> milking = new HashMap<>();

        this.milking = milking;
    }

    /**
     * The constructor, which takes all the parameters,and assigns it to the values in the class.
     * @param tagNo the tag number of the animal.
     * @param gender the gender of the animal.
     * @param dateOfBirth the birthday of the animal.
     * @param purchased the purchased of the animal.
     * @param milking the milking of the animal.
     * @param treatment the treatment of the animal.
     */
    public Animal(int tagNo, String gender, Calendar dateOfBirth, boolean purchased, HashMap milking, ArrayList<Treatment> treatment) {
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = Calendar.getInstance();
        this.dateOfBirth.set(dateOfBirth.get(Calendar.YEAR),dateOfBirth.get(Calendar.MONTH),dateOfBirth.get(Calendar.DATE));
        this.purchased = purchased;
        this.milking = milking;
        this.treatment = new ArrayList<Treatment>();
        for (int i=0; i < treatment.size();i++){
            this.treatment.add(treatment.get(i));
        }
    }

    /**
     * Calculates animal age.
     * @return age of animal.
     */
    public int getAge(){
        int age,current;
        Calendar calendar = Calendar.getInstance();
        current = calendar.get(Calendar.YEAR);
        age = this.dateOfBirth.get(Calendar.YEAR);
        age = current - age;
        return age;
    }
    /**
     * Gets animal's tag number.
     * @return tag number of animal.
     */
    public int getTagNo() {
        return tagNo;
    }

    /**
     * Sets animal's tag number.
     * @param tagNo tagNo the new tag number of the animal.
     */
    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    /**
     * Gets animal's gender.
     * @return gender of animal.
     */
    public String getGender() {
        return gender;
    }

    /**
     *  Sets animal's gender.
     * @param gender gender the new gender of the animal.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets animal's birthdate.
     * @return birthdate of animal.
     */
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets animal's birthdate.
     * @param dateOfBirth dateOfBirth the new birthdate of the animal.
     */
    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets animal's purchased.
     * @return purchased of animal.
     */
    public boolean isPurchased() {
        return purchased;
    }

    /**
     * Sets animal's purchased.
     * @param purchased purchased of animal.
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**
     * Gets animal's milking.
     * @return milking of animal
     */
    public HashMap getMilking() {
        return milking;
    }

    /**
     * Sets animal's milking.
     * @param milking milking of animal.
     */
    public void setMilking(HashMap milking) {
        this.milking = milking;
    }

    /**
     * Gets all animal treatments in a arrayList.
     * @return all animal treatments.
     */
    public ArrayList<Treatment> getTreatment() {
        return treatment;
    }

    /**
     * Sets all animal treatments within an ArrayList.
     * @param treatment treatment the new treatments of the animal.
     */
    public void setTreatment(ArrayList<Treatment> treatment) {
        this.treatment = treatment;
    }

    /**
     * abstract method, common method for sheep and cow.
     * Just a declaration.
     */
    public abstract String feeding();
}
