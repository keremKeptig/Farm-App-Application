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
public class Sheep extends Animal implements Serializable {

    /**
     * Default constructor makes all values initially zero or null.
     */
    public Sheep() {
    }

    /**
     * The constructor, which takes all the parameters,and assigns it to the values in the class.
     * @param tagNo tagNo the tag number of the sheep.
     * @param gender gender the gender of the sheep.
     * @param dateOfBirth dateOfBirth the birthday of the sheep.
     * @param purchased  purchased of the sheep.
     * @param milking  milking of the sheep.
     * @param treatment treatment of the sheep.
     */
    public Sheep(int tagNo, String gender, Calendar dateOfBirth, boolean purchased, HashMap milking, ArrayList<Treatment> treatment) {
        super(tagNo, gender, dateOfBirth, purchased, milking, treatment);
    }
    public Sheep(int tagNo, String gender, Calendar dateOfBirth, boolean purchased) {
        super(tagNo, gender, dateOfBirth, purchased, new HashMap(), new ArrayList<Treatment>());
    }

    /**
     * Override for feeding function. Displays cow feeding details.
     */
    public String feeding()
    {
        int age = getAge();
        if (age < 5 && getGender().equals("male")){
            return "Sheep is fed with grass";
        }else if(age < 8 && getGender().equals("female")){
            return "Sheep is fed with grass";
        }else if(age > 5 && getGender().equals("male")){
            return "Sheep is diet with Total mixed \n" +
                    "ration (TMR)";
        }else if(age > 8 && getGender().equals("female")){
            return "Sheep is diet with Total mixed \n" +
                    "ration (TMR)";
        }else{
            return "";
        }
    }

}
