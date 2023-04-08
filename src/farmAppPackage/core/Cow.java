package farmAppPackage.core;

import farmAppPackage.support.Animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *  Class is subclass of animal that additionally double value.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public class Cow extends Animal implements Serializable {

    private double weight;
    /**
     *  Default constructor makes all values initially zero or null.
     */
    public Cow() {
        this.weight = 0.0;
    }

    /**
     * The constructor, which takes all the parameters,and assigns it to the values in the class.
     * @param tagNo tagNo the tag number of the cow.
     * @param gender the gender of the cow.
     * @param dateOfBirth dateOfBirth the birthday of the cow.
     * @param purchased purchased of the cow.
     * @param milking milking of the cow.
     * @param treatment treatment of the cow.
     * @param weight weight of the cow.
     */

    public Cow(int tagNo, String gender, Calendar dateOfBirth, boolean purchased, HashMap milking, ArrayList<Treatment> treatment, double weight) {
        super(tagNo, gender, dateOfBirth, purchased, milking, treatment);
        this.weight = weight;
    }
    public Cow(int tagNo, String gender, Calendar dateOfBirth, boolean purchased, double weight) {
        super(tagNo, gender, dateOfBirth, purchased, new HashMap<>(), new ArrayList<Treatment>());
        this.weight = weight;
    }


    /**
     * Override for feeding function. Displays cow feeding details.
     */
    public String feeding()
    {
        int age = getAge();
        if (age < 3){
            return "Cow is fed with grass";
        }else if(age > 5 && getWeight() < 500){
            return "Cow is fed (TMR) with hay, fermented grass (silage), maize silage and \n" +
                    "high energy grains like brewers grains, soy bean, cotton \n" +
                    "seed and citrus pulp.";
        }else if(age > 10){
            return "Cow is fed grains and oilseed meals";
        }else{
            return "Cow is fed with grass and grains";
        }
    }

    /**
     * Gets cow's weight.
     * @return cow's weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the cow's weight.
     * @param weight new weight for cow's weight.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }


}
