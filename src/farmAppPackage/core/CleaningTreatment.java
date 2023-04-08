package farmAppPackage.core;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Class is subclass of treatment that additionally has attributes that string and farmWorker.
 * @author Kerem Keptig 2453355.
 * @version JDK 19
 */
public class CleaningTreatment extends Treatment implements Serializable {
    private String materialsused;
    private FarmWorker farmWorker;

    /**
     * The constructor, which takes date of treatment, material used and assigns it to the values in the class.
     * @param dateOFTreatment date of treatment.
     * @param materialsused materialused of cleaning treatment.
     */
    public CleaningTreatment(Calendar dateOFTreatment, String materialsused) {
        super(dateOFTreatment);
        this.materialsused = materialsused;
        this.farmWorker = new FarmWorker();
    }

    /**
     * The constructor, which takes date of treatment, material used, farmWorker and assigns it to the values in the class.
     * @param dateOFTreatment date of treatment.
     * @param materialsused materialused of cleaning treatment.
     * @param farmWorker farmWorker of cleaning treatment.
     */
    public CleaningTreatment(Calendar dateOFTreatment, String materialsused, FarmWorker farmWorker) {
        super(dateOFTreatment);
        this.materialsused = materialsused;
        this.farmWorker = farmWorker;
    }

    /**
     * Default constructor makes all values initially zero or null.
     */
    public CleaningTreatment() {
        this.materialsused = "Unknown";
        this.farmWorker = new FarmWorker();
    }

    /**
     * The constructor, which takes material used and assigns it to the values in the class.
     * @param materialsused materialused of cleaning treatment.
     */
    public CleaningTreatment(String materialsused) {
        this.materialsused = materialsused;
    }

    /**
     * Gets farmWorker of cleaning treatment.
     * @return farmWorker of cleaning treatment.
     */
    public FarmWorker getFarmWorker() {
        return farmWorker;
    }

    /**
     * Sets farmWorker of cleaning treatment.
     * @param farmWorker farmWorker the new farmWorker of cleaning treatment.
     */
    public void setFarmWorker(FarmWorker farmWorker) {
        this.farmWorker = farmWorker;
    }

    /**
     * Gets materialused of cleaning treatment.
     * @return materialused of cleaning treatment.
     */
    public String getMaterialsused() {
        return materialsused;
    }

    /**
     * Sets materialsused of cleaning treatment.
     * @param materialsused materialsused the new materialsused of cleaning treatment.
     */
    public void setMaterialsused(String materialsused) {
        this.materialsused = materialsused;
    }
}
